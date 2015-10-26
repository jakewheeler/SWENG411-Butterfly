package audio;

import java.util.ArrayList;

/**
 *
 * @author natec
 */
public class SongList {
    protected String name;
    protected ArrayList<Song> songList;
    
    public SongList(String name)
    {
        this.songList = new ArrayList<>();
        this.name = name;
    }
    
    public SongList(String name, Song song)
    {
        this.name = name;
        this.songList = new ArrayList<>();
        this.songList.add(song);
    }
    
    public SongList(String name, ArrayList<Song> songs)
    {
        this.songList = new ArrayList<>();
        this.name = name;
        this.songList.addAll(songs);
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void addSong(Song song)
    {
        this.songList.add(song);
    }
    
    public void addSongs(ArrayList<Song> songs)
    {
        this.songList.addAll(songs);
    }
    
    public void removeSong(Song song)
    {
        this.songList.remove(song);
    }
    
    public int getLength()
    {
        return this.songList.size();
    }
    
    public ArrayList<Song> getList()
    {
        return this.songList;
    }
}
