package audio;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import org.cmc.music.common.ID3ReadException;
import org.cmc.music.metadata.MusicMetadata;
import org.cmc.music.metadata.MusicMetadataSet;
import org.cmc.music.myid3.MyID3;

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
    private MusicMetadata metadata;
    private  final File songfile;
    private final JFXPanel jfxp; // required to initialize JavaFX library
    private final URL url;
   
            
    public Song(String artist, String album, String songName, String filePath) throws IOException
    {
        this.artist = artist;
        this.album = album;
        this.songName = songName;
        this.filePath = filePath;
        
        // Media player stuff initiliazation
        this.songfile = new File(filePath);
        this.url = songfile.toURI().toURL();
        this.jfxp = new JFXPanel();
        this.audio = new Media(url.toString());
    }
    
    public Song(String filePath) throws IOException, ID3ReadException
    {
        this.filePath = filePath;
//        MusicMetadataSet h = new MyID3().read(songfile);
//        this.metadata = (MusicMetadata) h.getSimplified();
//        String def = "Unknown";
//        
//        this.artist = metadata.getArtist().equals("") ? metadata.getArtist() : def;
//        this.album = metadata.getAlbum().equals("") ? metadata.getAlbum() : def;
//        this.songName = metadata.getSongTitle().equals("") ? metadata.getSongTitle() : def;
//        this.genre = metadata.getGenreName().equals("") ? metadata.getGenreName() : def;
//        this.numberOnAlbum = metadata.getTrackNumberNumeric() == null ? metadata.getTrackNumberNumeric().intValue() : 0;
//        this.songLength = metadata.getDurationSeconds().intValue() / 60 + ":" + metadata.getDurationSeconds().intValue() % 60;
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
        //this.metadata.setAlbum(artist);
    }
    
    public String getAlbum()
    {
        return this.album;
    }
    
    public void setAlbum(String album)
    {
        this.album = album;
        //this.metadata.setAlbum(album);
    }
    
    public String getSongName()
    {
        return this.songName;
    }
    
    public void setSongName(String songName)
    {
        this.songName = songName;
        //this.metadata.setSongTitle(songName);
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
        //this.metadata.setGenreName(genre);
    }
    
    public int getNumberOnAlbum()
    {
        return this.numberOnAlbum;
    }
    
    public void setNumberOnAlbum(int num)
    {
        this.numberOnAlbum = num;
        //this.metadata.setTrackNumberNumeric(num);
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
