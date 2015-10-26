package main;

import audio.PlayList;
import audio.Song;
import audio.SongList;
import audio.SongQueue;
import butterfly.AudioControl;
import butterfly.SearchHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import ui.AudioControlUI;

/**
 *
 * @author Nate Christiansen, Jake Wheeler, Nick Kapty
 */

public class Main 
{

    public static void main(String[] args) throws IOException 
    {
        ArrayList<Song> list = new ArrayList();
        Song song0 = new Song("testingsongs/Hustler Musik.mp3");
        Song song1 = new Song("testingsongs/Flux and Flow.mp3");
        Song song2 = new Song("testingsongs/Harmony.mp3");
        Song song3 = new Song("testingsongs/Light Pollution.mp3");
        Song song4 = new Song("Perturbator", "Test", "Perturbator", "testingsongs/Perturbator.mp3");
        Song song5 = new Song("FutureShock", "Test", "EnV", "testingsongs/FutureShock.mp3");
        
        System.out.println(song0.getArtist());
        System.out.println(song0.getSongName()); //Test cases for mp3 tag library

        song0.setArtist("Lil' Wayne");
        song1.setArtist("Lights");
        song2.setArtist("Ian Taylor");
        song3.setArtist("Lights");
        
        song0.setAlbum("Test");
        song1.setAlbum("Test");
        song2.setAlbum("Test");
        song3.setAlbum("Test");
        
        song0.setSongName("Hustler Musik");
        song1.setSongName("Flux and Flow");
        song2.setSongName("Harmony");
        song3.setSongName("Light Pollution");
        
        list.add(song0);
        list.add(song1);
        list.add(song2);
        list.add(song3);
        list.add(song4);
        list.add(song5);
        
        SongQueue library = new SongQueue(list);
        
        SearchHelper search = new SearchHelper(library);
        
        SongList search1 = search.search(" Flux and flow ");
        search1.getList().forEach(song -> System.out.println(song.getSongName()));
        
        // Testing AudioControlUI
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AudioControl ac = new AudioControl(library);
        frame.getContentPane().add(new AudioControlUI(ac));
        frame.pack();
        frame.setVisible(true); 

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ac.playSong(song4);
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ac.newQueue(library);
    }    
}
