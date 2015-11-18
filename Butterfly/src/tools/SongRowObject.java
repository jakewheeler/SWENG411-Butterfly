package tools;

import audio.Song;

/**
 *
 * @author natec
 */
public class SongRowObject {
    private final Song storedSong;
    
    public SongRowObject(Song song)
    {
        this.storedSong = song;
    }
    
    public Song getSong()
    {
        return this.storedSong;
    }
    
    public Object[] getRowInfo()
    {
        return new Object[]{
            this.storedSong.getSongName(),
            this.storedSong.getArtist(), 
            this.storedSong.getAlbum(),
            this.storedSong.getGenre(),
            this.storedSong.getYear(),
            this.storedSong.getFormattedLength(),
            this.storedSong.getNumberOnAlbum()
        };
    }
}
