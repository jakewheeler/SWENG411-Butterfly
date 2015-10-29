package butterfly;

import audio.Song;
import audio.SongList;
import audio.SongQueue;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
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
    private double volume = 1;
    
    public AudioControl()
    {
        this.queue = new SongQueue();
    }
    
    public AudioControl(SongList list)
    {
        this.queue = new SongQueue(list.getList());
        changeSong();
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
        updateUI();
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
        changeSong();
        this.play();
    }
    
    // skip to previous song
    public void previous()
    {
        this.stop();
        this.queue.previous();
        changeSong();
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
        changeSong();
        this.play();
    }
    
    // changes the queue to have the new list
    public void newQueue(SongList songs)
    {
        this.stop();
        this.queue.clear();
        this.queue.setCurrentSong(songs.getList());
        changeSong();
        this.play();
    }
    
    private void updateUI()
    {
        Song song = this.queue.getCurrentSong();
        this.ui.SongLabel.setText(song.getSongName());
        this.ui.ArtistLabel.setText(song.getArtist());
        this.ui.AlbumLabel.setText(song.getAlbum());
        this.ui.setSongEndLabel(song.getFormattedLength());
        this.ui.SongLocationSlider.setValue(0);
    }
    
    // change the volume of media player
    public void setVolume(double volume)
    {
        this.volume = volume;
        this.mp.setVolume(this.volume);
    }
    
    private void changeSong()
    {
        this.mp = new MediaPlayer(this.queue.getCurrentSong().getAudio());
        this.mp.setOnEndOfMedia(() -> this.next());
        this.mp.setVolume(this.volume);
    }
    
    // percentage is an int from 0 to 100
    public void setDuration(int percentage)
    {
        Song song = this.queue.getCurrentSong();
        int millsec = song.getSongLength() * 1000;
        double newDuration = ((double) (millsec * percentage)) / 100;
        this.mp.seek(new Duration(newDuration));
    }
}
