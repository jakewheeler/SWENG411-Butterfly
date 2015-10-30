package butterfly;

import audio.Song;
import audio.SongList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.AudioPlayerUI;

/**
 *
 * @author natec
 */
public final class AudioPlayer 
{
    private AudioPlayerUI ui;
    private AudioControl audiocontrol;
    private SearchHelper searchhelper;
    private SongBrowser songbrowser;

    public AudioPlayer()
    {
        try {
            initMain();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public void setSearchHelper(SearchHelper helper)
    {
        this.searchhelper = helper;
    }
    
    public SongList search(String words)
    {
        return this.searchhelper.search(words);
    }
    
    public void setUI(AudioPlayerUI ui)
    {
        this.ui = ui;
    }
    
    public void initMain() throws IOException
    {
        LibraryManager manager = new LibraryManager();
        ArrayList<File> mp3s = manager.getSongsInDirectory("testingsongs");
        ArrayList<Song> list = new ArrayList<>();
        
        for (int i = 0; i < mp3s.size(); i++)
        {
            list.add(new Song(mp3s.get(i).getPath()));
        }
        
        list.sort((Song song1, Song song2) -> song1.getArtist().compareTo(song2.getArtist()));
        
        SongList library = new SongList("Library", list);

        this.ui = new AudioPlayerUI();
        this.ui.setComponents(this);
        AudioControl ac = new AudioControl(library);
        ac.setUI(this.ui.acui);
        this.ui.acui.setController(ac);
        
        SongBrowser sb = new SongBrowser(library);
        this.ui.SongBrowserUI.setController(sb);
        sb.setUI(this.ui.SongBrowserUI);
        sb.displaySongList();
        this.ui.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        AudioPlayer player = new AudioPlayer();
    }
}
