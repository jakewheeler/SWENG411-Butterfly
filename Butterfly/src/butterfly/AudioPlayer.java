package butterfly;

import audio.Album;
import audio.ArtistSongList;
import audio.ISongList;
import audio.Library;
import audio.PlayList;
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
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import tools.AlbumEditor;
import ui.AudioPlayerUI;
import tools.PlayListMenu;
import tools.RightClickMenu;
import tools.SongEditor;
import tools.ArtistEditor;
import tools.PlaylistEditor;

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
    private ArrayList<String> musicpaths;
    
    private final String libraryfile = "Library.bdf";
    private final String locationfile = "LibraryLocation.bdf";

    public AudioPlayer() throws IOException
    {
        try 
        {
            initMain();
        } 
        catch (Exception ex) 
        {
            AudioPlayer.HandleException(ex);
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
    
    @SuppressWarnings("unchecked")
    public void initMain() throws InterruptedException, IOException
    {
        // create the library object
        Thread getlibthread = new Thread(() -> {
            this.manager = new LibraryManager();   
            
            try 
            {
                this.library = (Library) this.readFromFile(this.libraryfile);
            } 
            catch (Exception ex) 
            {
                this.library = null;
            }           
            
            try
            {
                this.musicpaths = (ArrayList<String>) this.readFromFile(this.locationfile);
            } 
            catch (Exception ex)
            {
                this.musicpaths = null;
            }
            
            if (this.musicpaths != null)
                this.musicpaths.forEach(path -> this.addSongsToLibrary(path));
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
            if (this.songbrowser.getCurrentList() != null)
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
                this.twitterHelper = new TwitterHelper(this, this.ui);
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
            this.ui.AudioControlUI.TwitterButtonControl.setTwitterHelper(this.twitterHelper);
        });
        twtthread.start();
                
        // wait for all threads
        acthread.join();
        sbthread.join();
        lbthread.join();
        twtthread.join();
    }
    
    private Object readFromFile(String path) throws Exception
    {
        FileInputStream in;
        File f = new File(path);
        try
        {                
            in = new FileInputStream(f);
        } 
        catch (FileNotFoundException ex) 
        {
            f.createNewFile();
            in = new FileInputStream(f);
        }

        ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));
        Object readObject = oin.readObject();
        oin.close();
        return readObject;
    }
    
    public void closing()
    {
        try {
            this.writeToFile(this.libraryfile, this.library);
            this.writeToFile(this.locationfile, this.musicpaths);
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }      
    }
    
    private void writeToFile(String path, Object objectToWrite) throws IOException
    {
        File f = new File(path);
        Files.deleteIfExists(f.toPath());
        FileOutputStream out = new FileOutputStream(f);
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(out))) {
            oos.writeObject(objectToWrite);
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
    
    public TwitterHelper getTwitterHelper()
    {
        return this.twitterHelper;
    }
    
    public AudioControl getAudioControl()
    {
        return this.audiocontrol;
    }
    
    public void addMusicFolder()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(this.ui) == JFileChooser.APPROVE_OPTION)
        {
            try 
            {
                String canonicalPath = chooser.getSelectedFile().getCanonicalPath();
                if (this.musicpaths == null)
                    this.musicpaths = new ArrayList<>();
                
                if (!this.musicpaths.contains(canonicalPath.toLowerCase()));
                {
                    this.addSongsToLibrary(canonicalPath);
                    this.musicpaths.add(canonicalPath);
                }
            } 
            catch (IOException ex) {
                AudioPlayer.HandleException(ex);
            }
        }        
    }
    
    private void addSongsToLibrary(String musicFolderPath)
    {
        ArrayList<String> filepaths = new ArrayList<>();
        if (this.library != null)
            this.library.getList().forEach(song -> filepaths.add(song.getFilePath()));
        
        ArrayList<File> newSongs = this.manager.getSongsInDirectory(musicFolderPath, filepaths);
        
        if (newSongs.isEmpty()) return;
        
        ArrayList<Song> list = new ArrayList<>();
            
        newSongs.stream().forEach((mp3) -> {
            try {
                list.add(new Song(mp3.getPath()));
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
        });

        if (this.library == null)
            this.library = new Library(list);
        else
            this.library.addSongs(list);
        
        if (this.libbrowser == null) return;
        this.libbrowser.update();
    }
    
    public void songRightClicked(Song song, int x, int y)
    {
        new Thread(()->{
            RightClickMenu menu = new RightClickMenu(this, song);
            menu.setLocation(MouseInfo.getPointerInfo().getLocation());
            menu.setVisible(true);
        }).start();
    }
    
    public void artistRightClicked(String artist, int x, int y)
    {
        new Thread(() -> {
            RightClickMenu menu = new RightClickMenu(this, this.library.getArtist(artist));
            menu.setLocation(MouseInfo.getPointerInfo().getLocation());
            menu.setVisible(true);
        }).start();
    }
    
    public void playlistRightClicked(String playlist, int x, int y)
    {
        new Thread(() -> {
            RightClickMenu menu = new RightClickMenu(this, this.library.getPlayList(playlist));
            menu.setLocation(MouseInfo.getPointerInfo().getLocation());
            menu.setVisible(true);            
        }).start();
    }
    
    public void albumRightClicked(String album, int x, int y)
    {
        new Thread(() -> {
            RightClickMenu menu = new RightClickMenu(this, this.library.getAlbum(album));
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
        this.audiocontrol.removeSongFromQueue(song);
    }
    
    public void removeSongFromLibrary(Song song)
    {
        this.library.removeSong(song);
        this.songbrowser.removeSong(song);
        this.audiocontrol.removeSongFromQueue(song);
        this.libbrowser.update();
    }
    
    public void editSongInfo(Song song)
    {
        if (this.audiocontrol.getCurrentSong() == song) return;
        
        new Thread(()-> {
            this.library.removeSong(song);
            SongEditor editor = new SongEditor(song);
            editor.setLocation(MouseInfo.getPointerInfo().getLocation());
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                        AudioPlayer.HandleException(ex);
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
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
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
                    } catch (Exception ex) {
                        AudioPlayer.HandleException(ex);
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
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
        }).start();
    }
    
    public void editArtistInfo(ISongList artist)
    {
        new Thread(()-> {
            ArtistEditor editor = new ArtistEditor(this, (ArtistSongList) artist);
            editor.setLocation(MouseInfo.getPointerInfo().getLocation());
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                        AudioPlayer.HandleException(ex);
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
                this.songbrowser.refresh();
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
        }).start();
    }
    
    public void removePlaylistFromLibrary(ISongList list)
    {
        this.library.removePlayList((PlayList) list);
        this.libbrowser.update();
    }
    
    public void editPlaylistInfo(ISongList list)
    {
        new Thread(()-> {
            PlaylistEditor editor = new PlaylistEditor(this, (PlayList) list);
            editor.setLocation(MouseInfo.getPointerInfo().getLocation());
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                        AudioPlayer.HandleException(ex);
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
                this.songbrowser.refresh();
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
        }).start();
    }
    
    public void addSongListToQueue(ISongList list)
    {
        this.audiocontrol.addSongsToQueue(list);
    }
    
    public void removeSongListFromLibrary(ISongList list)
    {
        this.songbrowser.removeSongs(list.getList());
        this.audiocontrol.removeSongsFromQueue(list.getList());
        this.library.removeSongs(list.getList());
        this.libbrowser.update();
    }
    
    public void editAlbumInfo(ISongList album)
    {
        new Thread(()-> {
            AlbumEditor editor = new AlbumEditor(this, (Album) album);
            editor.setLocation(MouseInfo.getPointerInfo().getLocation());
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                        AudioPlayer.HandleException(ex);
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
                this.songbrowser.refresh();
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
        }).start();
    }
    
    public void addSonglistToPlaylist(ISongList list)
    {
        new Thread(()-> {
            PlayListMenu editor = new PlayListMenu(this, list);
            editor.setLocation(MouseInfo.getPointerInfo().getLocation());
            editor.setVisible(true);
            Thread t = new Thread(()->{
                while (editor.isVisible()){
                    try {
                        Thread.sleep(10);
                    } catch (Exception ex) {
                        AudioPlayer.HandleException(ex);
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
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
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
    
    public void addToPlayList(String name, ISongList list)
    {
        this.library.addListToPlayList(name, list);
    }
    
    public static void main(String[] args) throws IOException
    {
        AudioPlayer player = new AudioPlayer();
    }
    
    public static void HandleException(Exception ex)
    {
        Logger.getLogger(Song.class.getName()).log(Level.SEVERE, null, ex);
    }
}
