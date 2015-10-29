package butterfly;

import audio.SongList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private final SongList library;
    SearchHelper searcher;
    
    public SongBrowser(SongList library)
    {
        this.library = library;
        this.searcher = new SearchHelper(library);
    }
        
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (SongBrowserUI) ui;
    }
    
    // simply adds all songs in the SongList to the SongBrowserUI table
    public void addSongsToLibrary()
    {
        DefaultTableModel model = (DefaultTableModel) this.ui.LibraryTable.getModel();
        
        for (int i = 0; i < this.library.getLength(); i++)
        {
          model.addRow( new Object[] { this.library.getList().get(i).getSongName(), this.library.getList().get(i).getArtist(), this.library.getList().get(i).getAlbum() } );  
        }        
    }
    
    public void displaySongList(SongList list)
    {        
        DefaultTableModel model = (DefaultTableModel) this.ui.LibraryTable.getModel();
        model.setRowCount(0);
        
        for (int i = 0; i < list.getLength(); i++)
        {
          model.addRow( new Object[] { list.getList().get(i).getSongName(), list.getList().get(i).getArtist(), list.getList().get(i).getAlbum() } );  
        }
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
        } catch (InterruptedException ex) {
            Logger.getLogger(SongBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
        search = st.getResult();
        this.displaySongList(search);
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
