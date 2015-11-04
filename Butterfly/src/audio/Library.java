package audio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author natec
 */
public class Library extends SongList
{
    HashMap<String, ArtistSongList> artists;
    HashMap<String, Album> albums;
    
    public Library(ArrayList<Song> list) 
    {
        super("Library");
        this.songList = list;
        this.artists = new HashMap<>();
        this.albums = new HashMap<>();
        this.organize();
    }
    
    public ArtistSongList getArtist(String name)
    {
        return this.artists.get(name);
    }
    
    public ArtistSongList getArtistBySong(Song song)
    {
        return this.artists.get(song.getArtist());
    }
    
    public Album getAlbum(String name)
    {
        return this.albums.get(name);
    }
    
    public Album getAlbumBySong(Song song)
    {
        return this.albums.get(song.getAlbum());
    }
    
    @Override
    public void removeSong(Song song)
    {
        this.artists.get(song.getArtist()).removeSong(song);
        super.songList.remove(song);
    }
    
    private void organize()
    {
        this.songList.stream().forEach(song -> {
            if (this.artists.get(song.getArtist()) == null)
                this.artists.put(song.getArtist(), new ArtistSongList(song.getArtist(), song));
            else
                this.artists.get(song.getArtist()).addSong(song);
        });
        
        this.artists.entrySet().stream().forEach((artist) -> {
            this.albums.putAll(artist.getValue().getAlbums());
        });
    }
}
