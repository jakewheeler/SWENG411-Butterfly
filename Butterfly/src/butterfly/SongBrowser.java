package butterfly;

import audio.SongList;
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
    
    public SongBrowser(SongList library)
    {
        this.library = library;
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
}
