package butterfly;

import audio.Song;
import java.awt.Color;
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
import ui.AudioPlayerUI;
import ui.IAudioUI;
import ui.TweetTemplate;
import ui.TwitterHelperUI;

/**
 *
 * Jake
 */
public class TwitterHelper implements IAudioController
{    
    private final AudioPlayer audioPlayer;
    private final AudioPlayerUI parentUI; // needed to center dialogs
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
    private final String twitterFileName = "twitter.bdf"; // file where credentials are stored
    private String authenticationURL;
    private boolean hasCredentials;
    private final int TWITTER_MESSAGE_MAX_LEN = 140; // max tweet length
    private String defaultTweet;
    private final String butterflyURL = "goo.gl/sgtVjx"; // Butterfly's github URL using google's url shorten tool
    private final String PINErrorMessage = "Your PIN appears to be incorrect. Exit this window and try again.";
    private final String tooManyCharsInTweetError = "There are too many characters in your tweet. Submit a shorter message.";
    private final String reauthenticationSuccess = "Press the Twitter button to complete reauthentication.";
    private final String noSongDataError = "No song data found. Please begin playing a song and try again.";

    public TwitterHelper(AudioPlayer audioPlayer, AudioPlayerUI parentUI) throws IOException
    {
        file = new File(twitterFileName);
        file.createNewFile();
        pinIsCorrect = true;
        this.audioPlayer = audioPlayer;
        this.parentUI = parentUI;
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
        ArrayList<String> temp = new ArrayList<>();
        Scanner s = new Scanner(file);
        while (s.hasNext())
            temp.add(s.nextLine());
        
        return temp.get(0); 
    }
    
    // grab saved secret access token from the file if it exists already
    private String getSavedAccessTokenSecret() throws FileNotFoundException, IOException
    {
        ArrayList<String> temp = new ArrayList<>();
        Scanner s = new Scanner(file);
        while (s.hasNext())
            temp.add(s.nextLine());

        return temp.get(1);  
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
                JOptionPane.showMessageDialog(this.parentUI, PINErrorMessage, "Incorrect PIN", JOptionPane.ERROR_MESSAGE);
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
        String message = temp.TweetTextArea.getText(); // user message
        
        if (message.length() < TWITTER_MESSAGE_MAX_LEN)
        {
            twitter.updateStatus(message); // tweet message
            JOptionPane.showMessageDialog(this.parentUI, "Your status has been successfully updated."); // let user know
            temp.dispatchEvent(new WindowEvent(temp, WindowEvent.WINDOW_CLOSING)); // close the form
        }
        else
        {
            // let user know there was an issue. Form stays open until success.
            JOptionPane.showMessageDialog(this.parentUI, tooManyCharsInTweetError, "Tweet length error", JOptionPane.ERROR_MESSAGE);
        }
            
    }
    
    // creates and displays the tweet template form
    public void createTweetTemplate()
    {
        JFrame frame = new JFrame();
        TweetTemplate template = new TweetTemplate(this, frame, true);
        template.setLocationRelativeTo(parentUI); // center in AudioPlayerUI
        Song song = audioPlayer.getAudioControl().getCurrentSong();
       
        try
        {
            defaultTweet = "I'm currently listening to '" + song.getSongName() + "' by " + song.getArtist() + " using Butterfly Music Player. " + butterflyURL;
            if (defaultTweet.length() < TWITTER_MESSAGE_MAX_LEN)
            {
                template.TweetTextArea.setText(defaultTweet);
                template.TweetLengthLabel.setText(Integer.toString(TWITTER_MESSAGE_MAX_LEN - template.TweetTextArea.getText().length()));
                counterLabelColorController(template, template.TweetTextArea.getText().length());
            }
            else
            {
                defaultTweet = "I'm currently listening to '" + song.getSongName() + "' by " + song.getArtist() + " using Butterfly Music Player.";
                template.TweetTextArea.setText(defaultTweet);
                template.TweetLengthLabel.setText(Integer.toString(TWITTER_MESSAGE_MAX_LEN - template.TweetTextArea.getText().length()));
                counterLabelColorController(template, template.TweetTextArea.getText().length());
            }
        } catch (Exception ex) 
        {
            template.TweetTextArea.setText(noSongDataError);
            template.TweetLengthLabel.setText(Integer.toString(TWITTER_MESSAGE_MAX_LEN - template.TweetTextArea.getText().length()));
            // no reason to change label color here
        }
       
        template.setVisible(true); 
    }
    
    // creates and displays the pin entry form
    public void createPinEntryForm()
    {
        JFrame frame = new JFrame();
        TwitterHelperUI twitterHelperUI = new TwitterHelperUI(frame, true);
        twitterHelperUI.setLocationRelativeTo(parentUI); // center in AudioPlayerUI
        twitterHelperUI.setController(this);
        twitterHelperUI.setVisible(true);
    }
    
    // check to see if PIN is valid or not
    public boolean getPinStatus()
    {
        return pinIsCorrect;
    }
    
    // gets the twitter message max length
    public int getTwitterMessageMaxLength()
    {
        return TWITTER_MESSAGE_MAX_LEN;
    }
    
    // changes the label to black/red depending on the amount of characters in the tweet template
    public void counterLabelColorController(TweetTemplate tweetTemplate, int text)
    {
        if (TWITTER_MESSAGE_MAX_LEN - text > 0)
            tweetTemplate.TweetLengthLabel.setForeground(Color.white);
        else
            tweetTemplate.TweetLengthLabel.setForeground(Color.red);
    }
    
    // makes the twitter file empty (for reauthentication purposes)
    public void clearTwitterBdfFile()
    {
        if (file.exists())
        {
          try
          {
            PrintWriter w = new PrintWriter(file);
            w.close();
            JOptionPane.showMessageDialog(this.parentUI, reauthenticationSuccess);  
          }catch(Exception ex)
          {
              AudioPlayer.HandleException(ex);
          }
          
        }
    }
}
