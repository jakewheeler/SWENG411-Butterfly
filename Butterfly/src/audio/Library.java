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
        this.playlists = new TreeMap<>();
        this.organize(list);
    }
    
    public Library()
    {
        this.artists = new TreeMap<>();
        this.playlists = new TreeMap<>();        
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
        ArtistSongList artist = this.artists.get(song.getArtist());
        artist.removeSong(song);
        if (artist.getList().isEmpty())
            this.artists.remove(artist.getName());
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
    
    public void addPlaylist(String name)
    {
        if (!this.playlists.containsKey(name))
            this.playlists.put(name, new PlayList(name));
    }
    
    public void addPlaylist(String name, Song song)
    {
        if (!this.playlists.containsKey(name))
            this.playlists.put(name, new PlayList(name, song));
    }
    
    public void addPlaylist(String name, ArrayList<Song> songs)
    {
        if (!this.playlists.containsKey(name))
            this.playlists.put(name, new PlayList(name, songs));
    }
    
    public void addSongToPlaylist(String name, Song song)
    {
        PlayList list = this.playlists.get(name);
        if (!list.songList.contains(song))
            list.addSong(song);
    }
    
    public ISongList getAllPlaylists()
    {
        ArrayList<Song> list = new ArrayList<>();
        this.playlists.entrySet().forEach(playlist -> {
            list.addAll(playlist.getValue().getList());
        });
        
        return new SongList(list);
    }
    
    public TreeMap<String, ArtistSongList> getArtistMap()
    {
        return this.artists;
    }
    
    public TreeMap<String, PlayList> getPlayListMap()
    {
        return this.playlists;
    }
}
