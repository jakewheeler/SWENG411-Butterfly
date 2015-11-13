package butterfly;

import audio.ISongList;
import audio.Song;
import audio.SongList;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ui.IAudioUI;
import ui.SongBrowserUI;

/**
 *
 * @author natec
 */
public class SongBrowser implements IAudioController
{
    private SongBrowserUI ui;
    private final AudioPlayer player;
    private final SearchHelper searcher;
    private ISongList currentList;
    
    public SongBrowser(AudioPlayer player)
    {
        this.player = player;
        this.searcher = new SearchHelper(this.player);
        
        if (this.player.getLibrary() == null) return;
        this.currentList = new SongList(this.player.getLibrary().getList());
    }
        
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (SongBrowserUI) ui;
    }
    
    // simply adds all songs in the SongList to the SongBrowserUI table
    public void displaySongList()
    {
        DefaultTableModel model = (DefaultTableModel) this.ui.LibraryTable.getModel();
        
        for (int i = 0; i < this.player.getLibrary().getLength(); i++)
        {
            Song song = this.player.getLibrary().getList().get(i);
            model.addRow( new Object[] 
            {
                song.getSongName(),
                song.getArtist(), 
                song.getAlbum(),
                song.getGenre(),
                song.getYear(),
                song.getFormattedLength()
            });  
        }        
    }
    
    public void displaySongList(ISongList list)
    {        
        DefaultTableModel model = (DefaultTableModel) this.ui.LibraryTable.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < list.getLength(); i++)
        {
            Song song = list.getList().get(i);
            model.addRow(new Object[] 
            {
                song.getSongName(),
                song.getArtist(), 
                song.getAlbum(),
                song.getGenre(),
                song.getYear(),
                song.getFormattedLength()
            });  
        }
        this.currentList = list;
    }
    
    public ISongList getCurrentList()
    {
        return this.currentList;
    }
    
    public void playList()
    {
        int songIndex = this.ui.LibraryTable.getSelectedRow();
        this.player.changeQueue(this.currentList.getList().get(songIndex), currentList);
    }
    
    // threaded this to slightly boost performance, searching a lot of songs still breaks shit
    // it is very fast with 70k songs though
    public void search(String words)
    {
        SongList search;
        SearchThread st = new SearchThread(words, this.searcher);
        Thread t = new Thread(st);
        t.start();
        try {
            t.join();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        search = st.getResult();
        this.displaySongList(search);
    }
    
    public void rightClick(Point p)
    {
        new Thread(() -> {
            int row = this.ui.LibraryTable.rowAtPoint(p);
            this.ui.LibraryTable.setRowSelectionInterval(row, row);
            this.player.songRightClicked(this.currentList.getList().get(row), p.x, p.y);
        }).start();
    }
    
    public void removeSong(Song song)
    {
        this.currentList.removeSong(song);
        this.refresh();
    }
    
    public void removeSongs(ArrayList<Song> songs)
    {
        songs.forEach(song -> this.removeSong(song));
        this.refresh();
    }
    
    public void refresh()
    {
        this.displaySongList(this.currentList);
    }

    private class SearchThread implements Runnable
    {
        private final SearchHelper sh;
        private final String words;
        private SongList result;
        
        SearchThread(String words, SearchHelper sh)
        {
            this.words = words;
            this.sh = sh;
        }
        
        @Override
        public void run() {
            this.result = sh.search(words);
        }
        
        SongList getResult()
        {
            return this.result;
        }
    }
}
