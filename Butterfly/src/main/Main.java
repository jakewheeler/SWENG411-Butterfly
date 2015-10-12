package main;

import audio.Song;
import audio.SongQueue;
import java.util.ArrayList;

/**
 *
 * @author Nate Christiansen, Jake Wheeler, Nick Kapty
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Song song0 = new Song(null, "ha");
        Song song1 = new Song(null, "he");
        Song song2 = new Song(null, "hi");
        Song song3 = new Song(null, "ho");
        Song song4 = new Song(null, "hu");
        
        ArrayList<Song> list = new ArrayList<>();
        list.add(song0);
        list.add(song1);
        list.add(song2);
        list.add(song3);
        list.add(song4);
        
        SongQueue queue = new SongQueue(list);
        
        queue.next();
        queue.next();
        queue.previous();
        queue.shuffle();
        queue.clear();
        Song s = queue.getCurrentSong();
        
    }    
}
