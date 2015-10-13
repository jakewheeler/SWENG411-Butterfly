package main;

import audio.Song;
import java.io.File;
import java.io.IOException;
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
        Song song = new Song("Hulster Musik.mp3");
    }    
}
