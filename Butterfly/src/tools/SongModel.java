package tools;

import audio.Song;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author natec
 */
public class SongModel extends DefaultTableModel
{
    private Song storedSong;

    public SongModel()
    {
        super(
            new Object [][] {},
            new String [] {
                "Song", "Artist", "Album", "Genre", "Year", "Length", "Track #"
            });
    }

    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    public Song getSong()
    {
        return this.storedSong;
    }
}
