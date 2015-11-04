package butterfly;

import audio.Library;
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
    private LibraryManager manager;
    private Library library;

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
        this.manager = new LibraryManager();
        ArrayList<File> mp3s = this.manager.getSongsInDirectory("testingsongs");
        
        /*
         *  add your own music directory 
         *  watch the magic happen
         *  still throws a ton of exceptions but we'll cross that bridge when we get to it
         */
        mp3s.addAll(this.manager.getSongsInDirectory("F:\\Music"));
        
        ArrayList<Song> list = new ArrayList<>();
        
        mp3s.stream().forEach(mp3 -> {
            try {
                list.add(new Song(mp3.getPath()));
            } catch (IOException ex) {
                System.out.println("Error reading " + mp3);
            }
        });
        
        list.sort((Song song1, Song song2) -> song1.getArtist().compareTo(song2.getArtist()));
        
        this.library = new Library(list);

        this.audiocontrol = new AudioControl(this);
        this.audiocontrol.setUI(this.ui.acui);
        this.ui.acui.setController(this.audiocontrol);
        
        this.songbrowser = new SongBrowser(this);
        this.ui.SongBrowserUI.setController(this.songbrowser);
        this.songbrowser.setUI(this.ui.SongBrowserUI);
        this.songbrowser.displaySongList();
    }
    
    public void changeQueue(Song song, SongList newList)
    {
        this.audiocontrol.newQueue(song, newList);
    }
    
    public static void main(String[] args)
    {
        AudioPlayer player = new AudioPlayer();
    }
    
    public Library getLibrary()
    {
        return this.library;
    }
}
