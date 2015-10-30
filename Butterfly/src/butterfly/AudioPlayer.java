package butterfly;

import audio.Song;
import audio.SongList;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Song> list = new ArrayList<>();
        Song song0 = new Song("testingsongs/Hustler Musik.mp3");
        Song song1 = new Song("testingsongs/Flux and Flow.mp3");
        Song song2 = new Song("testingsongs/Harmony.mp3");
        Song song3 = new Song("testingsongs/Light Pollution.mp3");
        Song song4 = new Song("testingsongs/Perturbator.mp3");
        Song song5 = new Song("testingsongs/FutureShock.mp3");
        Song song6 = new Song("testingsongs/My Really Short Song.mp3");
        
        for (int i = 0; i < 10000; i++)
        {
            list.add(song0);
            list.add(song1);
            list.add(song2);
            list.add(song3);
            list.add(song4);
            list.add(song5);
            list.add(song6);
        }
        
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
