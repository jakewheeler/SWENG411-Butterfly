package audio;

import java.util.ArrayList;

/**
 *
 * @author natec
 */
public class SongList implements ISongList
{
    protected ArrayList<Song> songList;
    
    public SongList()
    {
        this.songList = new ArrayList<>();
    }
    
    public SongList(Song song)
    {
        this.songList = new ArrayList<>();
        this.songList.add(song);
    }
    
    public SongList(ArrayList<Song> songs)
    {
        this.songList = new ArrayList<>();
        this.songList.addAll(songs);
    }
    
    @Override
    public void addSong(Song song)
    {
        this.songList.add(song);
    }
    
    @Override
    public void addSongs(ArrayList<Song> songs)
    {
        songs.forEach(song -> this.addSong(song));
    }
    
    @Override
    public void removeSong(Song song)
    {
        this.songList.remove(song);
    }
    
    @Override
    public int getLength()
    {
        return this.songList.size();
    }
    
    @Override
    public ArrayList<Song> getList()
    {
        return this.songList;
    }        

    @Override
    public void removeSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.removeSong(song));
    }
}
