package butterfly;

import audio.PlayList;
import audio.Song;
import audio.SongList;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author natec
 */
public class SearchHelper {
    SongList library;
    public SearchHelper(SongList library)
    {
        this.library = library;
    }
    
    public SongList search(String keyword)
    {
        SongList list = new PlayList("Search Result");
        list.addSongs((ArrayList<Song>) library.getList().stream().filter(song -> contains(song, keyword)).collect(Collectors.toList()));
        return list;
    }
    
    private boolean contains(Song song, String keyword)
    {
        return keyword.equals(song.getArtist()) || keyword.equals(song.getAlbum()) || keyword.equals(song.getGenre()) || keyword.equals(song.getSongName());
    }
}
