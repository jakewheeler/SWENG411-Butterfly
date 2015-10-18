package audio;

import java.util.ArrayList;

/**
 *
 * @author natec, jakew
 */
public class PlayList extends SongList
{
    public PlayList(String name)
    {
        super(name);
    }
    
    public PlayList(String name, ArrayList<Song> song)
    {
        super(name, song);
    }
}
