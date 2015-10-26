package butterfly;

import audio.Song;
import audio.SongList;
import audio.SongQueue;
import javafx.scene.media.MediaPlayer;
import ui.AudioControlUI;
import ui.IAudioUI;

/**
 *
 * @author Jake
 */
public class AudioControl implements IAudioController
{
    private MediaPlayer mp;
    private boolean playFlag;
    private final SongQueue queue;
    private AudioControlUI ui;
    
    public AudioControl()
    {
        this.queue = new SongQueue();
    }
    
    public AudioControl(SongList list)
    {
        this.queue = new SongQueue(list.getList());
        mp = new MediaPlayer(this.queue.getCurrentSong().getAudio());
    }
    
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (AudioControlUI) ui;
    }
    
    // starts playing from the beginning
    public void play()
    {
        mp.play();
        playFlag = true;
    }
    
    public boolean isPlaying()
    {
        return playFlag;
    }
    
    // pauses current song
    public void pause()
    {
       mp.pause();
       playFlag = false;
    }
    
    // stops current song
    public void stop()
    {
        this.mp.stop();
        playFlag = false;
    }
    
    // set song label
    public String getCurrentSong()
    {
       return this.queue.getCurrentSong().getSongName();
    }
    
    // set artist label
    public String getCurrentArtist()
    {
      return this.queue.getCurrentSong().getArtist();
    }
    
    // set album label
    public String getCurrentAlbum()
    {
      return this.queue.getCurrentSong().getAlbum();
    }
    
    // skips to next song
    public void next()
    {
        this.stop();
        this.queue.next();
        this.mp = new MediaPlayer(this.queue.getCurrentSong().getAudio());
        this.play();
    }
    
    // skip to previous song
    public void previous()
    {
        this.stop();
        this.queue.previous();
        this.mp = new MediaPlayer(this.queue.getCurrentSong().getAudio());
        this.play();
    }
    
    // toggle queue to repeat song
    public void repeat()
    {
        this.queue.toggleRepeat();
    }
    
    // tell queue to shuffle
    public void shuffle()
    {
        this.queue.shuffle();
    }
    
    // adds a song to the current queue
    public void addSongsToQueue(Song song)
    {
        this.queue.addSong(song);
    }
    
    // adds a list of songs to the current queue
    public void addSongsToQueue(SongList songs)
    {
        this.queue.addSongs(songs.getList());
    }
    
    // clears the queue and plays the selected song
    public void playSong(Song song)
    {
        this.stop();
        this.queue.clear();
        this.queue.setCurrentSong(song);
        this.mp = new MediaPlayer(this.queue.getCurrentSong().getAudio());
        this.play();
    }
    
    // changes the queue to have the new list
    public void newQueue(SongList songs)
    {
        this.stop();
        this.queue.clear();
        this.queue.setCurrentSong(songs.getList());
        this.mp = new MediaPlayer(this.queue.getCurrentSong().getAudio());
        this.play();
    }
}
