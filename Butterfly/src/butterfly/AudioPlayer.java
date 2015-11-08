package butterfly;

import audio.ISongList;
import audio.Library;
import audio.Song;
import audio.SongList;
import java.awt.MouseInfo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.AudioPlayerUI;
import ui.PlayListMenu;
import ui.RightClickMenu;
import ui.SongEditor;
import java.lang.instrument.Instrumentation;

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
    private LibraryBrowser libbrowser;
    private Library library;
    private TwitterHelper twitterHelper;
    
    private final String libraryfile = "Library.bflib";
    
    private static Instrumentation ins;

    public AudioPlayer() throws IOException
    {
        try {
            initMain();
        } catch (InterruptedException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void displaySongs(ISongList list)
    {
        this.songbrowser.displaySongList(list);
    }
    
    public void initMain() throws InterruptedException, IOException
    {
        // create the library object
        Thread getlibthread = new Thread(() -> {
            try {
                File f = new File(this.libraryfile);
                FileInputStream in;
                try{                
                    in = new FileInputStream(f);
                } catch (FileNotFoundException ex) {
                    f.createNewFile();
                    in = new FileInputStream(f);
                }
                
                ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));
                this.library = (Library) oin.readObject();
                oin.close();
            } catch (IOException | ClassNotFoundException | NullPointerException ex) {
                this.library = null;
            }
            
            ArrayList<String> filepaths = new ArrayList<>();
            if (this.library != null)
                this.library.getList().forEach(song -> filepaths.add(song.getFilePath()));
            
            this.manager = new LibraryManager();
            ArrayList<File> mp3s = this.manager.getSongsInDirectory("testingsongs", filepaths);

            /*
             *  add your own music directory 
             *  watch the magic happen
             *  still throws a ton of exceptions but we'll cross that bridge when we get to it
             */
            mp3s.addAll(this.manager.getSongsInDirectory("F:\\Music", filepaths));

            ArrayList<Song> list = new ArrayList<>();
            
            for (File mp3 : mp3s)
            {
                try {
                    if (filepaths != null)
                        if (!filepaths.contains(mp3.getPath()))
                        {
                            list.add(new Song(mp3.getPath()));
                        }
                        else
                        {
                            
                        }
                    else
                    {
                        list.add(new Song(mp3.getPath()));
                    }
                    
                    mp3 = null;
                }
                catch (IOException ex){
                    System.out.println(ex);
                }
            }

//            mp3s.forEach(mp3 -> {
//                try {
//                    if (filepaths != null)
//                        if (!filepaths.contains(mp3.getPath()))
//                            list.add(new Song(mp3.getPath()));
//                    else
//                        list.add(new Song(mp3.getPath()));
//                } catch (IOException ex) {
//                    System.out.println("Error reading " + mp3);
//                }
//            });
            
            if (this.library == null)
                this.library = new Library(list);
            else
                this.library.addSongs(list);
        });        
        getlibthread.start();
        
        // initialize audioplayer ui
        this.ui = new AudioPlayerUI();
        this.ui.setComponents(this);
        this.ui.setVisible(true);
        
        // wait for library to finish loading
        getlibthread.join();

        // create the components that rely on library
        Thread acthread = new Thread(() -> {
            this.audiocontrol = new AudioControl(this);
            this.audiocontrol.setUI(this.ui.AudioControlUI);
            this.ui.AudioControlUI.setController(this.audiocontrol);
        });
        acthread.start();
        
        Thread sbthread = new Thread(() -> {
            this.songbrowser = new SongBrowser(this);
            this.ui.SongBrowserUI.setController(this.songbrowser);
            this.songbrowser.setUI(this.ui.SongBrowserUI);
            this.songbrowser.displaySongList();
        });
        sbthread.start();
        
        Thread lbthread = new Thread(() -> {
            this.libbrowser = new LibraryBrowser(this);
            this.ui.LibraryBrowserUI.setController(this.libbrowser);
            this.libbrowser.setUI(this.ui.LibraryBrowserUI);
            this.libbrowser.update();
        });
        lbthread.start();
        
        Thread twtthread = new Thread(() -> {
            try {
                this.twitterHelper = new TwitterHelper(this);
            } catch (IOException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.ui.TwitterButtonControl.setTwitterHelper(this.twitterHelper);
        });
        twtthread.start();
                
        // wait for all threads
        acthread.join();
        sbthread.join();
        lbthread.join();
        twtthread.join();
    }
    
    public void closing()
    {
        try {
            // Remove file before saving
            File f = new File(this.libraryfile);
            Files.deleteIfExists(f.toPath());
            // save library to file
            
            FileOutputStream out = new FileOutputStream(f);
            try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(out))) {
                Serializable s = this.library;
                oos.writeObject(s);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void changeQueue(Song song, ISongList newList)
    {
        this.audiocontrol.newQueue(song, newList);
    }
    
    public Library getLibrary()
    {
        return this.library;
    }
    
    public AudioControl getAudioControl()
    {
        return this.audiocontrol;
    }
    
    public void songRightClicked(Song song, int x, int y)
    {
        new Thread(()->{
            RightClickMenu menu = new RightClickMenu(this, song);
            menu.setLocation(MouseInfo.getPointerInfo().getLocation());
            menu.setVisible(true);
        }).start();
    }
    
    public void addSongToQueue(Song song)
    {
        this.audiocontrol.addSongsToQueue(song);
    }
    
    public void removeSongFromQueue(Song song)
    {
        this.audiocontrol.removesongFromQueue(song);
    }
    
    public void removeSongFromLibrary(Song song)
    {
        this.library.removeSong(song);
        this.songbrowser.removeSong(song);
        this.audiocontrol.removesongFromQueue(song);
        this.libbrowser.update();
    }
    
    public void editSongInfo(Song song)
    {
        if (this.audiocontrol.getCurrentSong() == song) return;
        
        new Thread(()-> {
            this.library.removeSong(song);
            SongEditor editor = new SongEditor(song);
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
            editor.addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we)
                {
                    editor.setVisible(false);
                }
            });
            try {
                t.join();
                this.library.addSong(song);
                this.libbrowser.update();
                this.songbrowser.refresh();
            } catch (InterruptedException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
    public void addSongToPlayList(Song song)
    {
        new Thread(()-> {
            PlayListMenu editor = new PlayListMenu(this, song);
            editor.setLocation(MouseInfo.getPointerInfo().getLocation());
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
            editor.addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we)
                {
                    editor.setVisible(false);
                }
            });
            try {
                t.join();
                this.libbrowser.update();
            } catch (InterruptedException ex) {
                Logger.getLogger(AudioPlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
    public ISongList getCurrentQueue()
    {
        return this.audiocontrol.getCurrentQueue();
    }
    
    public void addNewPlaylist(String name)
    {
        this.library.addPlaylist(name);
    }
    
    public void addToPlayList(String name, Song song)
    {
        this.library.addSongToPlaylist(name, song);
    }
    
    public static void premain(String args, Instrumentation ins)
    {
        AudioPlayer.ins = ins;
    }
    
    public static void main(String[] args) throws IOException
    {
        AudioPlayer player = new AudioPlayer();
    }
}
