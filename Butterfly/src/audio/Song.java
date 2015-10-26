package audio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import com.beaglebuddy.mp3.MP3;


/**
 *
 * @author natec
 */
public class Song {
    private String  artist = "", 
                    album = "", 
                    songName = "", 
                    filePath = "", 
                    genre = "", 
                    songLength = "";
    private int numberOnAlbum;
    private final Media audio;
    private MP3 mp3;
    private final File songfile;
    private final JFXPanel jfxp; // required to initialize JavaFX library
    private final URL url;
   
            
    public Song(String artist, String album, String songName, String filePath) throws IOException
    {
        this.artist = artist;
        this.album = album;
        this.songName = songName;
        this.filePath = filePath;
        
        // Media player stuff initialization
        this.songfile = new File(filePath);
        this.url = songfile.toURI().toURL();
        this.jfxp = new JFXPanel();
        this.audio = new Media(url.toString());
    }
    
    public Song(String filePath) throws IOException
    {
        this.filePath = filePath;
        
        this.mp3 = new MP3(filePath);
       
        String def = "Unknown"; //Needs new implementation
        
        this.artist = mp3.getBand(); //actually is artist
        this.album = mp3.getAlbum();
        this.songName = mp3.getTitle();
        this.genre = mp3.getMusicType();
        this.numberOnAlbum = mp3.getTrack();
        this.songLength = Integer.toString(mp3.getAudioDuration()); //returns length in seconds needs converted into formatted string 
        
        //Media Player stuff initialization
        this.songfile = new File(filePath);
        this.url = songfile.toURI().toURL();
        this.jfxp = new JFXPanel();
        this.audio = new Media(url.toString());
    }
    
    public String getArtist()
    {
        return this.artist;
    }
    
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    public String getAlbum()
    {
        return this.album;
    }
    
    public void setAlbum(String album)
    {
       this.album = album;       
    }
    
    public String getSongName()
    {
        return this.songName;
    }
    
    public void setSongName(String songName)
    {
        this.songName = songName;        
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;        
    }
    
    public int getNumberOnAlbum()
    {
        return this.numberOnAlbum;
    }
    
    public void setNumberOnAlbum(int num)
    {
        this.numberOnAlbum = num;        
    }
    
    public Media getAudio()
    {
        return this.audio;
    }
    
    public String getFilePath()
    {
        return this.filePath;
    }
}
