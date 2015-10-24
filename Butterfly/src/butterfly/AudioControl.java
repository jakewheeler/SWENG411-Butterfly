package butterfly;

import audio.Song;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Jake
 */
public class AudioControl implements IAudioPlayerComponent
{
    private MediaPlayer mp;
    private final Song currentSong;
    private boolean playFlag;
    
    public AudioControl(Song song)
    {
        this.currentSong = song;
        mp = new MediaPlayer(currentSong.getAudio());
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
    
    // set song label
    public String getCurrentSong()
    {
       return currentSong.getSongName();
    }
    
    // set artist label
    public String getCurrentArtist()
    {
      return currentSong.getArtist();
    }
    
    // set album label
    public String getCurrentAlbum()
    {
      return currentSong.getAlbum();
    }
}
