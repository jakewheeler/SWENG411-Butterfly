package ui;

import audio.Song;
import audio.SongList;
import butterfly.AudioControl;
import butterfly.AudioPlayer;
import butterfly.SongBrowser;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ncc5136
 */
public class AudioPlayerUI extends javax.swing.JFrame 
{
    private final AudioPlayer controller;
    public AudioPlayerUI(AudioPlayer controller) 
    {
        initComponents();
        try 
        {
            initMain();
        } catch (IOException ex) 
        {
            
        }
        this.controller = controller;
    }
    
    private void initMain() throws IOException
    {
        ArrayList<Song> list = new ArrayList<>();
        Song song0 = new Song("testingsongs/Hustler Musik.mp3");
        Song song1 = new Song("testingsongs/Flux and Flow.mp3");
        Song song2 = new Song("testingsongs/Harmony.mp3");
        Song song3 = new Song("testingsongs/Light Pollution.mp3");
        Song song4 = new Song("testingsongs/Perturbator.mp3");
        Song song5 = new Song("testingsongs/FutureShock.mp3");
        Song song6 = new Song("testingsongs/My Really Short Song.mp3");
        
        for (int i = 0; i < 10000; i++)
        {
            list.add(song0);
            list.add(song1);
            list.add(song2);
            list.add(song3);
            list.add(song4);
            list.add(song5);
            list.add(song6);
        }
        
        SongList library = new SongList("Library", list);

        AudioControl ac = new AudioControl(library);
        ac.setUI(acui);
        acui.setController(ac);
        
        SongBrowser sb = new SongBrowser(library);
        this.SongBrowserUI.setController(sb);
        sb.setUI(this.SongBrowserUI);
        sb.addSongsToLibrary();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SongBrowserPanel = new javax.swing.JPanel();
        acui = new ui.AudioControlUI();
        SongBrowserUI = new ui.SongBrowserUI();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout SongBrowserPanelLayout = new javax.swing.GroupLayout(SongBrowserPanel);
        SongBrowserPanel.setLayout(SongBrowserPanelLayout);
        SongBrowserPanelLayout.setHorizontalGroup(
            SongBrowserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1290, Short.MAX_VALUE)
        );
        SongBrowserPanelLayout.setVerticalGroup(
            SongBrowserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        acui.setPreferredSize(new java.awt.Dimension(1280, 100));

        SongBrowserUI.setPreferredSize(new java.awt.Dimension(1280, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SongBrowserUI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(acui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SongBrowserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SongBrowserUI, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SongBrowserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(acui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AudioPlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AudioPlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AudioPlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AudioPlayerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        AudioPlayer audioPlayer = new AudioPlayer();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AudioPlayerUI(audioPlayer).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SongBrowserPanel;
    private ui.SongBrowserUI SongBrowserUI;
    private ui.AudioControlUI acui;
    // End of variables declaration//GEN-END:variables
}
