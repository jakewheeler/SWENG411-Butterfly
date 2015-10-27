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
    private final MP3 mp3;
    private final File songfile;
    private final JFXPanel jfxp; // required to initialize JavaFX library
    private final URL url;
    
    public Song(String filePath) throws IOException
    {
        this.filePath = filePath;
        this.mp3 = new MP3(filePath);
        
        this.artist = getTag(mp3.getBand()); //actually is artist
        this.album = getTag(mp3.getAlbum());
        this.songName = getTag(mp3.getTitle());
        this.genre = getTag(mp3.getMusicType());
        this.numberOnAlbum = mp3.getTrack();
        this.songLength = mp3.getAudioDuration() / 60 + ":" + mp3.getAudioDuration() % 60;
                
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
        this.mp3.setBand(artist);
    }
    
    public String getAlbum()
    {
        return this.album;
    }
    
    public void setAlbum(String album)
    {
        this.album = album;  
        this.mp3.setAlbum(album);
    }
    
    public String getSongName()
    {
        return this.songName;
    }
    
    public void setSongName(String songName)
    {
        this.songName = songName;        
        this.mp3.setTitle(songName);
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;     
        this.mp3.setMusicType(genre);
    }
    
    public int getNumberOnAlbum()
    {
        return this.numberOnAlbum;
    }
    
    public void setNumberOnAlbum(int num)
    {
        this.numberOnAlbum = num;   
        this.mp3.setTrack(num);
    }
    
    public Media getAudio()
    {
        return this.audio;
    }
    
    public String getFilePath()
    {
        return this.filePath;
    }
    
    public String getFormattedLength()
    {
        return this.songLength;
    }
    
    public int getSongLength()
    {
        return this.mp3.getAudioDuration();
    }
    
    private String getTag(String tag)
    {
        return (tag == null || tag.isEmpty()) ? "Unknown" : tag;
    }
}
