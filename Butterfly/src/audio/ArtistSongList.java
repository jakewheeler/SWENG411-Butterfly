package audio;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author natec, jakew
 */
public class ArtistSongList implements INamedSongList
{    
    protected String name;
    protected HashMap<String, Album> albums;
    
    public ArtistSongList(String name)
    {
        this.name = name;
        this.albums = new HashMap<>();
    }
    
    public ArtistSongList(String name, Song song)
    {
        this.name = name;
        this.albums = new HashMap<>();
        this.addSong(song);
    }
    
    public ArtistSongList(String name, ArrayList<Song> songs)
    {
        this.name = name;
        this.albums = new HashMap<>();
        this.addSongs(songs);
    }
    
    public HashMap<String, Album> getAlbums()
    {
        return albums;
    }
    
    // adds a new album object to the hash of albums
    public void addAlbum(Album album)
    {
        albums.put(album.name, album);
    }
    
    // completely removes an album based on it's name
    public void removeAlbum(String name)
    {
        this.albums.remove(name);
    }
    
    // adds a song to the album it belongs to in the hashmap
    // if the album doesn't exist, create a new album with that songs info and add that song
    @Override
    public void addSong(Song song)
    {
        String albumname = song.getAlbum();
        if (!this.albums.containsKey(albumname))
            this.albums.put(albumname, new Album(albumname, song.getGenre(), song.getArtist(), song.getYear(), song));
        else 
            this.albums.get(albumname).addSong(song);
    }
    
    // finds the album the song is in, removes it
    // also removes the album from the list if there are no songs in it after removing
    @Override
    public void removeSong(Song song)
    {
        Album album = this.albums.get(song.getAlbum());
        album.removeSong(song);
        if (album.getList().isEmpty())
            this.albums.remove(album.name);
    }
    
    // returns the length of every album
    @Override
    public int getLength()
    {
        int i = 0;
        i = this.albums.entrySet().stream().map((album) -> album.getValue().getLength()).reduce(i, Integer::sum);
        return i;
    }
    
    // returns every songlist in every album by the artist
    @Override
    public ArrayList<Song> getList()
    {
        ArrayList<Song> list = new ArrayList<>();
        this.albums.entrySet().stream().forEach((album) -> {
            list.addAll(album.getValue().getList());
        });        
        return list;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        this.albums.entrySet().forEach(album -> album.getValue().setArtist(name));
    }

    @Override
    public void addSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.addSong(song));
    }

    @Override
    public void removeSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.removeSong(song));
    }
}
