package audio;

import javafx.scene.media.Media;
import org.cmc.music.metadata.MusicMetadata;

/**
 *
 * @author natec
 */
public class Song {
    private String artist, album, songName, filePath, genre, songLength;
    private int numberOnAlbum;
    private Media audio;
    
    public Song(MusicMetadata metadata, String filePath)
    {
        String def = "Unknown";
        this.artist = metadata.getArtist().equals("") ? metadata.getArtist() : def;
        this.album = metadata.getAlbum().equals("") ? metadata.getAlbum() : def;
        this.songName = metadata.getSongTitle().equals("") ? metadata.getSongTitle() : def;
        this.genre = metadata.getGenreName().equals("") ? metadata.getGenreName() : def;
        this.numberOnAlbum = metadata.getTrackNumberNumeric() == null ? metadata.getTrackNumberNumeric().intValue() : 0;
        this.songLength = metadata.getDurationSeconds().intValue() / 60 + ":" + metadata.getDurationSeconds().intValue() % 60;
        this.filePath = filePath;
        audio = new Media(filePath);
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
