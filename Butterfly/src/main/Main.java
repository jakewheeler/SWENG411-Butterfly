package main;

import audio.Song;
import audio.SongList;
import audio.SongQueue;
import butterfly.AudioControl;
import butterfly.SearchHelper;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Song> list = new ArrayList<>();
        Song song0 = new Song("testingsongs/Hustler Musik.mp3");
        Song song1 = new Song("testingsongs/Flux and Flow.mp3");
        Song song2 = new Song("testingsongs/Harmony.mp3");
        Song song3 = new Song("testingsongs/Light Pollution.mp3");
        Song song4 = new Song("testingsongs/Perturbator.mp3");
        Song song5 = new Song("testingsongs/FutureShock.mp3");
        Song song6 = new Song("testingsongs/My Really Short Song.mp3");
        
        System.out.println(song0.getSongName());
        System.out.println(song1.getSongName()); //Test cases for mp3 tag library
        System.out.println(song2.getSongName()); //Test cases for mp3 tag library
        System.out.println(song3.getSongName()); //Test cases for mp3 tag library
        System.out.println(song4.getSongName()); //Test cases for mp3 tag library
        System.out.println(song5.getSongName()); //Test cases for mp3 tag library
        System.out.println(song6.getSongName()); //Test cases for mp3 tag library
        
        //song2.setSongName("Hi");
        
        list.add(song0);
        list.add(song1);
        list.add(song2);
        list.add(song3);
        list.add(song4);
        list.add(song5);
        list.add(song6);
        
        SongQueue library = new SongQueue(list);
        
        SearchHelper search = new SearchHelper(library);
        
        SongList search1 = search.search(" Flux and flow ");
        search1.getList().forEach(song -> System.out.println(song.getSongName()));
        
        // Testing AudioControlUI
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AudioControl ac = new AudioControl(library);
        AudioControlUI acui = new AudioControlUI();
        ac.setUI(acui);
        acui.setController(ac);
        frame.getContentPane().add(acui);
        frame.pack();
        frame.setVisible(true); 
    }    
}
