package audio;

import java.util.ArrayList;

/**
 *
 * @author natec
 */
public class Album extends SongList{
    protected String genre, artist;
    protected int year;
    
    public Album(String name) {
        super(name);
        this.genre = "Unknown";
        this.artist = "Unknown";
        this.year = 0;
    }
    
    public Album(String name, ArrayList<Song> songs)
    {
        super(name, songs);
    }
    
    public Album(String name, String genre, String artist, int year, ArrayList<Song> songs)
    {
        super(name, songs);
        this.genre = genre;
        this.artist = artist;
        this.year = year;
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    public String getArtist()
    {
        return this.artist;
    }
    
    public void setArtist(String artist)
    {
        this.artist = artist;
    }
    
    public int getYear()
    {
        return this.year;
    }
    
    public void setYear(int year)
    {
        this.year = year;
    }
}
