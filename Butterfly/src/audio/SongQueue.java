package audio;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author natec
 */
public class SongQueue implements ISongList {
    private Song currentSong;
    private boolean isRepeat;
    private int index;
    private final ArrayList<Song> songList;
    
    public SongQueue(Song song)
    {
        this.songList = new ArrayList<>();
        this.addSong(song);
        this.currentSong = this.songList.get(0);
        this.currentSong.load();
        this.index = 0;
    }
    
    public SongQueue(ArrayList<Song> songs)
    {
        this.songList = new ArrayList<>();
        this.addSongs(songs);
        this.currentSong = this.songList.get(0);
        this.currentSong.load();
        this.index = 0;
    }
        
    // returns current playing song
    public Song getCurrentSong()
    {
        return this.currentSong;
    }
    
    // adds a song to the current queue
    // or sets the queue position to that song if it's in it
    public void setCurrentSong(Song song)
    {
        if (this.currentSong != null)
            this.currentSong.unload();
        this.currentSong = song;
        this.currentSong.load();
        if (!this.songList.contains(song))
            this.addSong(song);
        this.index = this.songList.indexOf(song);
    }
    
    // adds a songlist to the current queue and starts it from beginning
    public void setCurrentQueue(ArrayList<Song> songList)
    {
        if (this.currentSong != null)
            this.currentSong.unload();
        this.songList.addAll(songList);
        this.index = 0;
        this.currentSong = this.songList.get(index);
        this.currentSong.load();
    }
    
    // skips to the next song in the list
    public void next()
    {
        if (!this.isRepeat)
        {
            this.index++;
            if (this.index >= this.songList.size())
            {
                this.index = 0;
            }
            if (this.currentSong != null)
                this.currentSong.unload();
            this.currentSong = this.songList.get(this.index);
            this.currentSong.load();
        }
    }
    
    // skips to the previous song in the list
    public void previous()
    {
        if (!this.isRepeat)
        {
            this.index--;
            if (this.index < 0)
            {
                this.index = this.songList.size()-1;
            }
            if (this.currentSong != null)
                this.currentSong.unload();
            this.currentSong = this.songList.get(this.index);
            this.currentSong.load();
        }
    }
    
    // clears the entire songlist
    public void clear()
    {
        if (this.currentSong != null)
            this.currentSong.unload();
        this.songList.clear();
        this.currentSong = null;
        this.index = 0;
    }
    
    // turns on/off repeat of 1 song
    public void toggleRepeat()
    {
        this.isRepeat = !this.isRepeat;
    }
    
    // shuffles the songlist into a new order
    public void shuffle()
    {
        Collections.shuffle(this.songList);
        this.index = this.songList.indexOf(this.currentSong);
    }

    // adds any song to the queue if it is not already in it
    @Override
    public void addSong(Song song) {
        if (!this.songList.contains(song))
            this.songList.add(song);
    }

    // adds each song if the song is not found
    @Override
    public void addSongs(ArrayList<Song> songs) {
        songs.forEach(song -> this.addSong(song));
    }

    // removes a song
    @Override
    public void removeSong(Song song) {
        if (this.index >= this.songList.indexOf(song))
            this.index--;
        this.songList.remove(song);
    }
    
    // removes a collection of songs
    @Override
    public void removeSongs(ArrayList<Song> songs)
    {
        songs.forEach(song -> this.removeSong(song));
    }

    // returns the length of the songlist
    @Override
    public int getLength() {
        return this.songList.size();
    }

    // returns the actual list of songs
    @Override
    public ArrayList<Song> getList() {
        return this.songList;
    }
}
