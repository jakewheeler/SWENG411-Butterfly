package audio;

import java.util.ArrayList;

/**
 *
 * @author natec
 */
public interface ISongList 
{    
    public void addSong(Song song);
    
    public void addSongs(ArrayList<Song> songs);
    
    public void removeSong(Song song);
    
    public void removeSongs(ArrayList<Song> songs);
    
    public int getLength();
    
    public ArrayList<Song> getList();
}
