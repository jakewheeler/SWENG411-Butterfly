package main;

import audio.PlayList;
import audio.Song;
import audio.SongList;
import butterfly.SearchHelper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.media.Media;
import org.cmc.music.common.ID3ReadException;

/**
 *
 * @author Nate Christiansen, Jake Wheeler, Nick Kapty
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ID3ReadException {
        ArrayList<Song> list = new ArrayList();
        Song song0 = new Song("testingsongs/Hustler Musik.mp3");
        Song song1 = new Song("testingsongs/Flux and Flow.mp3");
        Song song2 = new Song("testingsongs/Harmony.mp3");
        Song song3 = new Song("testingsongs/Light Pollution.mp3");
        Song song4 = new Song("testingsongs/Perturbator.mp3");
        
        song0.setArtist("Lil Wayne");
        song1.setArtist("Lights");
        song2.setArtist("Ian Taylor");
        song3.setArtist("Lights");
        song4.setArtist("Perturbator");
        
        song0.setAlbum("Test");
        song1.setAlbum("Test");
        song2.setAlbum("Test");
        song3.setAlbum("Test");
        song4.setAlbum("Test");
        
        song0.setSongName("Hustler Musik");
        song1.setSongName("Flux and Flow");
        song2.setSongName("Harmony");
        song3.setSongName("Light Pollution");
        song4.setSongName("Perturbator");
        
        list.add(song0);
        list.add(song1);
        list.add(song2);
        list.add(song3);
        list.add(song4);
        
        SongList library = new PlayList("Library", list);
        
        SearchHelper search = new SearchHelper(library);
        
        SongList search1 = search.search("Lights   Test ");
        search1.getList().forEach(song -> System.out.println(song.getSongName()));
    }    
}
