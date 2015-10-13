package audio;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author natec
 */
public class Artist extends SongList{
    protected ArrayList<Album> albums;
    
    public Artist(String name)
    {
        super(name);
        this.albums = new ArrayList<>();
    }
    
    public Artist(String name, ArrayList<Song> songs)
    {
        super(name, songs);
        this.albums = new ArrayList<>();
    }
}
