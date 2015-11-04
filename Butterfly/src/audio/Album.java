package audio;

import java.util.ArrayList;

/**
 *
 * @author natec
 */
public class Album implements INamedSongList
{
    protected String name, genre, artist;
    protected int year;
    protected ArrayList<Song> songList;
    
    public Album(String name) 
    {
        this.name = name;
        this.genre = "Unknown";
        this.artist = "Unknown";
        this.year = 0;
        this.songList = new ArrayList<>();
    }
    
    public Album(String name, String genre, String artist, int year, Song song)
    {
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.year = year;
        this.songList = new ArrayList<>();
        this.addSong(song);
    }
    
    public String getGenre()
    {
        return this.genre;
    }
    
    public void setGenre(String genre)
    {
        this.genre = genre;
        this.songList.stream().forEach(song -> song.setGenre(genre));
    }
    
    public String getArtist()
    {
        return this.artist;
    }
    
    public void setArtist(String artist)
    {
        this.artist = artist;
        this.songList.forEach(song -> song.setArtist(artist));
    }
    
    public int getYear()
    {
        return this.year;
    }
    
    public void setYear(int year)
    {
        this.year = year;
        this.songList.forEach(song -> song.setYear(year));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.songList.forEach(song -> song.setAlbum(name));
    }

    @Override
    public void addSong(Song song) {
        this.songList.add(song);
    }

    @Override
    public void addSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.addSong(song));
    }

    @Override
    public void removeSong(Song song) {
        this.songList.remove(song);
    }

    @Override
    public void removeSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.removeSong(song));
    }

    @Override
    public int getLength() {
        return this.songList.size();
    }

    @Override
    public ArrayList<Song> getList() {
        return this.songList;
    }
}
