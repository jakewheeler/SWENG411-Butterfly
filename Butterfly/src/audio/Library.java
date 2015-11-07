package audio;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author natec
 */
public class Library implements ISongList
{
    protected TreeMap<String, ArtistSongList> artists;
    protected TreeMap<String, PlayList> playlists;
    
    public Library(ArrayList<Song> list) 
    {
        this.artists = new TreeMap<>();
        this.organize(list);
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
        Album foundAlbum = null;
        for (Map.Entry<String, ArtistSongList> artist : this.artists.entrySet()) {
            TreeMap<String, Album> albums = artist.getValue().getAlbums();
            if (albums.containsKey(name))
                foundAlbum = albums.get(name);
        }
        return foundAlbum;
    }
    
    @Override
    public void removeSong(Song song)
    {
        this.artists.get(song.getArtist()).removeSong(song);
    }
    
    private void organize(ArrayList<Song> songList)
    {
        songList.stream().forEach(song -> {
            if (this.artists.get(song.getArtist()) == null)
                this.artists.put(song.getArtist(), new ArtistSongList(song.getArtist(), song));
            else
                this.artists.get(song.getArtist()).addSong(song);
        });
    }

    @Override
    public void addSong(Song song) {
        if (!this.artists.containsKey(song.getArtist()))
            this.artists.put(song.getArtist(), new ArtistSongList(song.getArtist(), song));
        else
            this.artists.get(song.getArtist()).addSong(song);
    }

    @Override
    public void addSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.addSong(song));
    }

    @Override
    public int getLength() {
        int i = 0;
        i = this.artists.entrySet().stream().map((artist) -> artist.getValue().getLength()).reduce(i, Integer::sum);
        return i;
    }

    @Override
    public ArrayList<Song> getList() {
        ArrayList<Song> library = new ArrayList<>();
        this.artists.entrySet().forEach((artist) -> {
            library.addAll(artist.getValue().getList());
        });
                
        library.sort((Song song1, Song song2) -> song1.getArtist().compareTo(song2.getArtist()));
        return library;
    }

    @Override
    public void removeSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.removeSong(song));
    }
    
    public TreeMap<String, ArtistSongList> getLibraryMap()
    {
        return this.artists;
    }
}
