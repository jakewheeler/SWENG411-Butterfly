package butterfly;

import audio.Song;
import audio.SongList;
import audio.SongQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    // flag to check if song is playing or paused/stopped
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
        playFlag = false;
        this.mp.stop();
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
        this.queue.setCurrentQueue(songs.getList());
        changeSong();
        this.play();
    }
    
    // changes the queue to have the new list
    // sets song to currentsong
    public void newQueue(Song song, SongList songs)
    {
        this.stop();
        this.queue.clear();
        this.queue.setCurrentQueue(songs.getList());
        this.queue.setCurrentSong(song);
        changeSong();
        this.play();
    }
    
    private void updateUI()
    {
        Song song = this.queue.getCurrentSong();
        this.ui.SongLabel.setText(song.getSongName());
        this.ui.ArtistLabel.setText(song.getArtist());
        this.ui.AlbumLabel.setText(song.getAlbum());
        if (this.playFlag)
        {
            int time = (int) ((int) this.mp.getCurrentTime().toSeconds() / this.mp.getTotalDuration().toSeconds() * 1000);
            this.ui.SongLocationSlider.setValue(time);
        }
        else
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
        this.mp.setOnPlaying(() -> {
            this.ui.setSongEndLabel(this.queue.getCurrentSong().getFormattedLength());
            while ((int) this.mp.getCurrentTime().toSeconds() < (int) this.mp.getTotalDuration().toSeconds() && this.isPlaying())
            {
                try {
                    Thread.sleep(this.queue.getCurrentSong().getSongLength());
                } catch (InterruptedException ex) {
                    Logger.getLogger(AudioControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.ui.SongLocationSlider.setValue(this.ui.SongLocationSlider.getValue() + 1);
                int secs = (int) this.mp.getCurrentTime().toSeconds();
                this.ui.setSongStartLabel(String.format("%02d:%02d", secs / 60, secs % 60));
            }
        });
        this.mp.setVolume(this.volume);
    }
    
    // percentage is an int from 0 to 1000
    public void setDuration(int percentage)
    {
        Song song = this.queue.getCurrentSong();
        double millsec = song.getSongLength() * 1000;
        double newDuration = ((double) (millsec * percentage)) / 1000;
        this.mp.seek(new Duration(newDuration));
        int secs = (int) this.mp.getCurrentTime().toSeconds();
        this.ui.setSongStartLabel(String.format("%02d:%02d", secs / 60, secs % 60));
    }
}
