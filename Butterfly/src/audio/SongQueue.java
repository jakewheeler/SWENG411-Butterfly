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
    
    public void setCurrentSong(Song song, ArrayList<Song> songList)
    {
        this.currentSong = song;
        this.songList = songList;
        this.index = this.songList.indexOf(song);
    }
    
    public void next()
    {
        this.index++;
        if (this.index >= this.songList.size() && this.isRepeat)
        {
            this.index = 0;
        }
        else if (this.index >= this.songList.size())
        {
            this.currentSong = null;
            return;
        }
        
        this.currentSong = this.songList.get(this.index);
    }
    
    public void previous()
    {
        
        this.index--;
        if (this.index < 0 && this.isRepeat)
        {
            this.index = this.songList.size()-1;
        }
        else if (this.index < 0)
        {
            this.currentSong = null;
            return;
        }
        
        this.currentSong = this.songList.get(this.index);
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
