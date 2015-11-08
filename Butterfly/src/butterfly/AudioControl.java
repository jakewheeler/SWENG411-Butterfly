package butterfly;

import audio.ISongList;
import audio.Song;
import audio.SongList;
import audio.SongQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private final AudioPlayer player;
    private Icon pauseIMG;
    private Icon playIMG;
        
    public AudioControl(AudioPlayer player)
    {
        try
        {
            this.pauseIMG = new ImageIcon(getClass().getClassLoader().getResource("resources/pause.PNG"));
            this.playIMG = new ImageIcon(getClass().getClassLoader().getResource("resources/play.PNG")); 
        } 
        catch(Exception e){}
        
        this.player = player;
        this.queue = new SongQueue(this.player.getLibrary().getList());
        this.changeSong();
    }
    
    @Override
    public void setUI(IAudioUI ui)
    {
        this.ui = (AudioControlUI) ui;
    }
    
    // starts playing from the beginning
    public void play()
    {
        this.mp.play();
        this.playFlag = true;
        this.ui.PlayPauseButton.setIcon(pauseIMG); 
        this.updateUI();
    }
    
    // flag to check if song is playing or paused/stopped
    public boolean isPlaying()
    {
        return this.playFlag;
    }
    
    // pauses current song
    public void pause()
    {
        this.mp.pause();
        this.ui.PlayPauseButton.setIcon(playIMG);
        this.playFlag = false;
    }
    
    // stops current song
    public void stop()
    {
        this.playFlag = false;
        this.ui.PlayPauseButton.setIcon(playIMG);
        this.mp.stop();
    }
    
    // set song label
    public Song getCurrentSong()
    {
       return this.queue.getCurrentSong();
    }
    
    public String getPlayingSong()
    {
        Song song = this.queue.getCurrentSong();
        return song.getSongName();  
    }
    
    public String getPlayingArtist()
    {
        Song song = this.queue.getCurrentSong();
        return song.getArtist();
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
    public void addSongsToQueue(ISongList songs)
    {
        this.queue.addSongs(songs.getList());
    }
    
    public void removesongFromQueue(Song song)
    {
        if (this.queue.getCurrentSong() == song)
        {
            this.next();
        }
        this.queue.removeSong(song);
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
    public void newQueue(Song song, ISongList songs)
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
    
    // returns a copy of the current queue, however changing it will not affect current queue
    public ISongList getCurrentQueue()
    {
        return new SongList(this.queue.getList());
    }
}
