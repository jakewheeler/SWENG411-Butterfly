package butterfly;

import audio.Song;
import audio.SongList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
        initMain();
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
    
    public void initMain()
    {
        this.ui = new AudioPlayerUI();
        this.ui.setComponents(this);
        this.ui.setVisible(true);
        LibraryManager manager = new LibraryManager();
        ArrayList<File> mp3s = manager.getSongsInDirectory("testingsongs");
        
        /*
         *  add your own music directory 
         *  watch the magic happen
         *  still throws a ton of exceptions but we'll cross that bridge when we get to it
         */
        mp3s.addAll(manager.getSongsInDirectory("F:\\Music"));
        
        ArrayList<Song> list = new ArrayList<>();
        
        for (int i = 0; i < mp3s.size(); i++)
        {
            try {
                list.add(new Song(mp3s.get(i).getPath()));
            } catch (IOException ex) {
                System.out.println("Error reading " + mp3s.get(i));
            }
        }
        
        list.sort((Song song1, Song song2) -> song1.getArtist().compareTo(song2.getArtist()));
        
        SongList library = new SongList("Library", list);

        AudioControl ac = new AudioControl(library);
        ac.setUI(this.ui.acui);
        this.ui.acui.setController(ac);
        
        SongBrowser sb = new SongBrowser(library);
        this.ui.SongBrowserUI.setController(sb);
        sb.setUI(this.ui.SongBrowserUI);
        sb.displaySongList();
    }
    
    public static void main(String[] args)
    {
        AudioPlayer player = new AudioPlayer();
    }
}
