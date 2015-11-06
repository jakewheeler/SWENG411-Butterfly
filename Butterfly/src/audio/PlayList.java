package audio;

import java.util.ArrayList;

/**
 *
 * @author natec, jakew
 */
public class PlayList implements INamedSongList
{
    protected String name;
    protected ArrayList<Song> songList;
    
    public PlayList(String name)
    {
        this.name = name;
        this.songList = new ArrayList<>();
    }
    
    public PlayList(String name, Song song)
    {
        this.name = name;
        this.songList = new ArrayList<>();
        this.addSong(song);
    }
    
    public PlayList(String name, ArrayList<Song> songs)
    {
        this.name = name;
        this.songList = new ArrayList<>();
        this.addSongs(songs);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addSong(Song song) {
        this.songList.add(song);
    }

    @Override
    public void addSongs(ArrayList<Song> songs) {
        this.songList.addAll(songs);
    }

    @Override
    public void removeSong(Song song) {
        this.songList.remove(song);
    }

    @Override
    public int getLength() {
        return this.songList.size();
    }

    @Override
    public ArrayList<Song> getList() {
        return this.songList;
    }

    @Override
    public void removeSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.removeSong(song));
    }
}
