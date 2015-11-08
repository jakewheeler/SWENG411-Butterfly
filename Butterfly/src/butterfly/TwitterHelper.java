package butterfly;

import java.awt.Desktop;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import ui.IAudioUI;
import ui.TweetTemplate;
import ui.TwitterHelperUI;

/**
 *
 * Jake
 */
public class TwitterHelper implements IAudioPlayerComponent, IAudioController
{    
    private final AudioPlayer audioPlayer;
    private TwitterHelperUI ui;
    private final static String CONSUMER_KEY = "On1jnpdNyZoeCxSkF9SMSn6ya" ; // Butterfly consumer key
    private final static String CONSUMER_SECRET_KEY = "wxSEmY02AH5KWPufvFsD8xyBzsnmLHtxDBhSAbxaJUcDCr5r21"; // Butterfly consumer secret key
    private Twitter twitter;
    private RequestToken requestToken;
    private AccessToken accessToken;
    private String pin;
    private boolean pinIsCorrect;
    private PrintWriter writer;
    private final File file;
    private final String twitterFileName = "twitter.txt"; // file where credentials are stored
    private String authenticationURL;
    private boolean hasCredentials;
    private final int TWITTER_MESSAGE_MAX_LEN = 140; // max tweet length
    private String defaultTweet;
    private final String butterflyURL = "https://github.com/jakewheeler/SWENG411-Butterfly";
    private final String PINErrorMessage = "Your PIN appears to be incorrect. Exit this window and type it again carefully.";
    private final String tooManyCharsInTweetError = "There are too many characters in your tweet. Try again and submit a shorter message.";

    public TwitterHelper(AudioPlayer audioPlayer) throws IOException
    {
        file = new File(twitterFileName);
        file.createNewFile();
        pinIsCorrect = true;
        this.audioPlayer = audioPlayer;
    }
    
    @Override
    public void setUI(IAudioUI ui) 
    {
        this.ui = (TwitterHelperUI) ui;
    }
    
    // starts the twitter process (gives Butterfly's credentials to Twitter)
    public void startTwitter() throws TwitterException, IOException, URISyntaxException
    {
      twitter = new TwitterFactory().getInstance();
      twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET_KEY);
    }
    
    // checks whether credentials have already been saved before or not (skips authentication if unneeded)
    public void setCredentialMethod() throws FileNotFoundException, IOException, TwitterException, URISyntaxException
    {
       BufferedReader br1 = new BufferedReader(new FileReader(file));
      if (file.exists() && br1.readLine() != null)
      {
        // use saved credentials
        hasCredentials = true;
      }
      else
      {
        // get new credentials
         hasCredentials = false;
      } 
    }
    
    // opens authentication in default browser to make it easy for the user to get pin
    private void openAuthenticationURL() throws URISyntaxException, IOException
    {
        if (Desktop.isDesktopSupported())
            Desktop.getDesktop().browse(new URI(authenticationURL));
    }
    
     // grab saved access token from the file if it exists already
    private String getSavedAccessToken() throws FileNotFoundException
    {
        ArrayList temp = new ArrayList<>();
        Scanner s = new Scanner(file);
        while (s.hasNext())
            temp.add(s.nextLine());
        
       return temp.get(0).toString(); 
    }
    
    // grab saved secret access token from the file if it exists already
    private String getSavedAccessTokenSecret() throws FileNotFoundException, IOException
    {
        ArrayList temp = new ArrayList<>();
        Scanner s = new Scanner(file);
        while (s.hasNext())
            temp.add(s.nextLine());

        return temp.get(1).toString();  
    }
    
    // method to prepare twitter use with saved credentials
    public void useSavedCredentials() throws FileNotFoundException, IOException
    {
        String aToken = getSavedAccessToken();
        String aTokenSec = getSavedAccessTokenSecret();
        accessToken = new AccessToken(aToken, aTokenSec);
        twitter.setOAuthAccessToken(accessToken);
    }
    
    // method to prepare twitter use with new credentials
    public void getNewCredentials() throws FileNotFoundException, TwitterException, URISyntaxException, IOException
    {
         writer = new PrintWriter(file);
         
         requestToken = twitter.getOAuthRequestToken();
         authenticationURL = requestToken.getAuthenticationURL();
         openAuthenticationURL();
      
         accessToken = null;
    }
    
    // gets the pin from the user
    public void getPinFromUser()
    {
        JFrame frame = new JFrame();
        if (accessToken == null)
        {
            try
            {
                pin = ui.PINEntryTextField.getText();
                accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                writeTokensToFile();
                pinIsCorrect = true;

            } catch(TwitterException te)
            {
               JOptionPane.showMessageDialog(frame, PINErrorMessage, "Incorrect PIN", JOptionPane.ERROR_MESSAGE);
               pinIsCorrect = false;
            }
        } 
    }
    
    // writes the tokens to the twitter file
    private void writeTokensToFile()
    {
        writer.println(accessToken.getToken());
        writer.println(accessToken.getTokenSecret());
        writer.close();
    }
    
    // check for other classes to see if the user has credentials or not
    public boolean hasCredentialsStatus()
    {
        return hasCredentials;
    }
    
    // method used to tweet user's message
    public void sendTweet(TweetTemplate temp) throws TwitterException
    {
        JFrame frame = new JFrame(); // just using for JOPtion panes
        String message = temp.TweetTextArea.getText(); // user message
        
        if (message.length() < TWITTER_MESSAGE_MAX_LEN)
        {
           twitter.updateStatus(message); // tweet message
           JOptionPane.showMessageDialog(frame, "Your status has been successfully updated."); // let user know
           temp.dispatchEvent(new WindowEvent(temp, WindowEvent.WINDOW_CLOSING)); // close the form
        }
        else
        {
            // let user know there was an issue. Form stays open until success.
           JOptionPane.showMessageDialog(frame, tooManyCharsInTweetError, "Tweet length error", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
    // creates and displays the tweet template form
    public void createTweetTemplate()
    {
       JFrame frame = new JFrame();
       TweetTemplate template = new TweetTemplate(this, frame, true);
       
       try
       {
           defaultTweet = "I'm currently listening to '" + audioPlayer.getAudioControl().getPlayingSong() + "' by " 
                + audioPlayer.getAudioControl().getPlayingArtist() + " using Butterfly Music Player.\n" + butterflyURL;
           if (defaultTweet.length() < TWITTER_MESSAGE_MAX_LEN)
           {
              template.TweetTextArea.setText(defaultTweet); 
           }
           else
           {
               defaultTweet = "I'm currently listening to '" + audioPlayer.getAudioControl().getPlayingSong() + "' by " 
                + audioPlayer.getAudioControl().getPlayingArtist() + " using Butterfly Music Player.";
               template.TweetTextArea.setText(defaultTweet); 
                       
           }
       }
       catch(Exception e)
       {
           // text area is empty
       }
       
       template.setVisible(true); 
    }
    
    // creates and displays the pin entry form
    public void createPinEntryForm()
    {
        JFrame frame = new JFrame();
        TwitterHelperUI twitterHelperUI = new TwitterHelperUI(frame, true);
        twitterHelperUI.setController(this);
        twitterHelperUI.setVisible(true);
    }
    
    // check to see if PIN is valid or not
    public boolean getPinStatus()
    {
        return pinIsCorrect;
    }
    
    
}
