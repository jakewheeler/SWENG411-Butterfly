package audio;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author natec
 */
public class SongQueue extends SongList {
    private Song currentSong;
    private boolean isRepeat;
    private int index;
    
    public SongQueue()
    {
        super("Queue");
        this.currentSong = this.songList.get(0);
        this.index = 0;
    }
    
    public SongQueue(Song song)
    {
        super("Queue", song);
        this.currentSong = this.songList.get(0);
        this.index = 0;
    }
    
    public SongQueue(ArrayList<Song> songs)
    {
        super("Queue", songs);
        this.currentSong = this.songList.get(0);
        this.index = 0;
    }
        
    public Song getCurrentSong()
    {
        return this.currentSong;
    }
    
    public void setCurrentSong(Song song)
    {
        this.currentSong = song;
        if (this.songList.indexOf(song) <= 0)
            this.addSong(song);
        this.index = this.songList.indexOf(song);
    }
    
    public void setCurrentSong(ArrayList<Song> songList)
    {
        this.songList.addAll(songList);
        this.index = 0;
        this.currentSong = this.songList.get(index);
    }
    
    public void next()
    {
        if (!this.isRepeat)
        {
            this.index++;
            if (this.index >= this.songList.size())
            {
                this.index = 0;
            }

            this.currentSong = this.songList.get(this.index);
        }
    }
    
    public void previous()
    {
        if (!this.isRepeat)
        {
            this.index--;
            if (this.index < 0)
            {
                this.index = this.songList.size()-1;
            }

            this.currentSong = this.songList.get(this.index);
        }
    }
    
    public void clear()
    {
        this.songList = new ArrayList<>();
        this.currentSong = null;
        this.index = 0;
    }
    
    public void toggleRepeat()
    {
        this.isRepeat = !this.isRepeat;
    }
    
    public void shuffle()
    {
        Collections.shuffle(this.songList);
        this.index = this.songList.indexOf(this.currentSong);
    }
}
