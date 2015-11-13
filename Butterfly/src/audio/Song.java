package audio;

import butterfly.AudioPlayer;
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
    private int numberOnAlbum, year, songSeconds;
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
        if (this.mp3.getAudioDuration() == 0)
            this.mp3.setAudioDuration();
        this.songLength = String.format("%02d:%02d", this.mp3.getAudioDuration() / 60, this.mp3.getAudioDuration() % 60);
        this.songSeconds = this.mp3.getAudioDuration();
        this.mp3 = null;
    }
    
    public void load()
    { 
        try {
            this.songfile = new File(filePath);
            this.url = songfile.toURI().toURL();
            this.jfxp = new JFXPanel();
            this.audio = new Media(url.toString());
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
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
        initMp3();
        this.artist = artist;
        this.mp3.setBand(artist);
        try {
            this.mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
    }
    
    public String getAlbum()
    {
        return this.album;
    }
    
    public void setAlbum(String album)
    {
        initMp3();
        this.album = album;  
        this.mp3.setAlbum(album);
        try {
            this.mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
    }
    
    public String getSongName()
    {
        return this.songName;
    }
    
    public void setSongName(String songName)
    {
        initMp3();
        this.songName = songName;        
        this.mp3.setTitle(songName);
        try {
            this.mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        initMp3();
        this.genre = genre;     
        this.mp3.setMusicType(genre);
        try {
            this.mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
    }
    
    public int getNumberOnAlbum()
    {
        return this.numberOnAlbum;
    }
    
    public void setNumberOnAlbum(int num)
    {
        initMp3();
        this.numberOnAlbum = num;   
        this.mp3.setTrack(num);
        try {
            this.mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
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
        return this.songSeconds;
    }
    
    public int getYear()
    {
        return this.year;
    }
    
    public void setYear(int year)
    {
        initMp3();
        this.year = year;
        this.mp3.setYear(year);
        try {
            this.mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
    }
    
    public void updateSong(String name, String artist, String album, String genre, int year, int number)
    {
        initMp3();
        this.year = year;
        this.numberOnAlbum = number;
        this.genre = genre;
        this.album = album;
        this.artist = artist;
        this.songName = name;
        
        this.mp3.setTrack(this.numberOnAlbum);
        this.mp3.setAlbum(this.album);
        this.mp3.setBand(this.artist);
        this.mp3.setMusicType(this.genre);
        this.mp3.setTitle(this.songName);
        this.mp3.setYear(this.year);
        try {
            mp3.save();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        this.mp3 = null;
    }
    
    private void initMp3()
    {        
        if (this.mp3 == null)
            try {
                this.mp3 = new MP3(this.filePath);
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
    }
    
    private String getTag(String tag)
    {
        return (tag == null || tag.isEmpty()) ? "Unknown" : tag;
    }
}
