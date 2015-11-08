package audio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author natec
 */
public interface ISongList extends Serializable
{    
    public void addSong(Song song);
    
    public void addSongs(ArrayList<Song> songs);
    
    public void removeSong(Song song);
    
    public void removeSongs(ArrayList<Song> songs);
    
    public int getLength();
    
    public ArrayList<Song> getList();
}
