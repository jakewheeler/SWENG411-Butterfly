package audio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import com.beaglebuddy.mp3.MP3;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author natec
 */
public class Song implements Serializable
{
    private int numberOnAlbum, year;
    private transient Media audio;
    private transient MP3 mp3;
    private transient File songfile;
    private transient JFXPanel jfxp; // required to initialize JavaFX library
    private URL url;
    private String  artist = "", 
                    album = "", 
                    songName = "", 
                    filePath = "", 
                    genre = "", 
                    songLength = "";
    
    public Song(String filePath) throws IOException
    {
        this.filePath = filePath;
        this.mp3 = new MP3(filePath);
        
        this.artist = getTag(mp3.getBand()); //actually is artist
        this.album = getTag(mp3.getAlbum());
        this.songName = getTag(mp3.getTitle());
        this.genre = getTag(mp3.getMusicType());
        this.numberOnAlbum = mp3.getTrack(); 
        this.year = mp3.getYear();
    }
    
    public void load()
    { 
        try {
            this.songfile = new File(filePath);
            this.url = songfile.toURI().toURL();
            this.jfxp = new JFXPanel();
            this.audio = new Media(url.toString());
            if (this.mp3 == null)
                this.mp3 = new MP3(filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void unload()
    {
        this.songfile = null;
        this.url = null;
        this.jfxp = null;
        this.audio = null;
    }
    
    public String getArtist()
    {
        return this.artist;
    }
    
    public void setArtist(String artist)
    {
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.artist = artist;
        this.mp3.setBand(artist);
        try {
            this.mp3.save();
        } catch (IOException | IllegalStateException ex) {
            System.out.println(ex);
        }
    }
    
    public String getAlbum()
    {
        return this.album;
    }
    
    public void setAlbum(String album)
    {
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.album = album;  
        this.mp3.setAlbum(album);
        try {
            this.mp3.save();
        } catch (IOException | IllegalStateException ex) {
            System.out.println(ex);
        }
    }
    
    public String getSongName()
    {
        return this.songName;
    }
    
    public void setSongName(String songName)
    {
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.songName = songName;        
        this.mp3.setTitle(songName);
        try {
            this.mp3.save();
        } catch (IOException | IllegalStateException ex) {
            System.out.println(ex);
        }
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.genre = genre;     
        this.mp3.setMusicType(genre);
        try {
            this.mp3.save();
        } catch (IOException | IllegalStateException ex) {
            System.out.println(ex);
        }
    }
    
    public int getNumberOnAlbum()
    {
        return this.numberOnAlbum;
    }
    
    public void setNumberOnAlbum(int num)
    {
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.numberOnAlbum = num;   
        this.mp3.setTrack(num);
        try {
            this.mp3.save();
        } catch (IOException | IllegalStateException ex) {
            System.out.println(ex);
        }
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
        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        int secs = (int) this.audio.getDuration().toSeconds();
        this.songLength = String.format("%02d:%02d", secs / 60, secs % 60);
        return this.songLength;
    }
    
    public int getSongLength()
    {
        return (int) this.audio.getDuration().toSeconds();
    }
    
    public int getYear()
    {
        return this.year;
    }
    
    public void setYear(int year)
    {
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (IOException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.year = year;
        this.mp3.setYear(year);
        try {
            this.mp3.save();
        } catch (IOException | IllegalStateException ex) {
            Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getTag(String tag)
    {
        return (tag == null || tag.isEmpty()) ? "Unknown" : tag;
    }
}
