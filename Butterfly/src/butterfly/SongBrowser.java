package butterfly;

import audio.ISongList;
import audio.Song;
import audio.SongList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import ui.IAudioUI;
import ui.SongBrowserUI;
import ui.SongModel;

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
        this.ui.LibraryTable.setDefaultRenderer(Object.class, new CustomRenderer());
        this.ui.LibraryTable.setModel(new SongModel());
    }
    
    // simply adds all songs in the SongList to the SongBrowserUI table
    public void displaySongList()
    {
        SongModel model = new SongModel();
        
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
        
        this.ui.LibraryTable.setModel(model);
    }
    
    public void displaySongList(ISongList list)
    {        
        SongModel model = new SongModel();
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
        
        this.ui.LibraryTable.setModel(model);
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
    
    public void highlight(Point p)
    {
        int row = this.ui.LibraryTable.rowAtPoint(p);
        this.ui.LibraryTable.setRowSelectionInterval(row, row);
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
    
    private class CustomRenderer extends DefaultTableCellRenderer
    {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component field = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected)
            {
                field.setBackground(new Color(0x1ED760));
                field.setForeground(Color.black);
            }
            else
            {
                field.setBackground((row % 2) == 0 ? new Color(51, 51, 51) : new Color(71, 71, 71));
                field.setForeground(Color.white);
            }
            return field;
        }        
    }
}
