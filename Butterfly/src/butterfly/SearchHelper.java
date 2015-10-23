package butterfly;

import audio.PlayList;
import audio.Song;
import audio.SongList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        // Create a new arraylist based on the string given, splits on spaces
        ArrayList<String> keywords = new ArrayList<>(Arrays.asList(keyword.trim().split(" +")));
        
        // Create a list and add any song that matches all of the keywords entered
        SongList list = new PlayList("Search Result");
        list.addSongs((ArrayList<Song>) library.getList().stream().filter(song -> contains(song, new ArrayList(keywords))).collect(Collectors.toList()));
        return list;
    }
    
    private boolean contains(Song song, List<String> keywords)
    {
        if (keywords.size() > 1)
        {
            String keyword = keywords.remove(0);
            return compare(song, keyword) && contains(song, keywords);
        }
        else
            return compare(song, keywords.get(0));
    }
    
    private boolean compare(Song song, String keyword)
    {        
        return  keyword.toLowerCase().equals(song.getArtist().toLowerCase()) || 
                keyword.toLowerCase().equals(song.getAlbum().toLowerCase()) || 
                keyword.toLowerCase().equals(song.getGenre().toLowerCase()) || 
                keyword.toLowerCase().equals(song.getSongName().toLowerCase());
    }
}
