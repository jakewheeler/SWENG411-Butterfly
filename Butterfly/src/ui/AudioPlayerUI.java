package ui;

import butterfly.AudioPlayer;
import java.awt.Color;

/**
 *
 * @author ncc5136
 */
public class AudioPlayerUI extends javax.swing.JFrame 
{
    private AudioPlayer controller;
    public AudioPlayerUI() 
    {/* Set the Nimbus look and feel */
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
        initComponents();
        this.getContentPane().setBackground(Color.BLACK); // not working in editor, works in here....
    }
    
    public void setComponents(AudioPlayer controller)
    {
        this.controller = controller;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        acui = new ui.AudioControlUI();
        SongBrowserUI = new ui.SongBrowserUI();
        libraryBrowserUI1 = new ui.LibraryBrowserUI();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Butterfly");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1360, 720));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        acui.setPreferredSize(new java.awt.Dimension(1280, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 33;
        getContentPane().add(acui, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 990;
        gridBagConstraints.ipady = 504;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        getContentPane().add(SongBrowserUI, gridBagConstraints);

        libraryBrowserUI1.setMinimumSize(new java.awt.Dimension(400, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(libraryBrowserUI1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public ui.SongBrowserUI SongBrowserUI;
    public ui.AudioControlUI acui;
    public ui.LibraryBrowserUI libraryBrowserUI1;
    // End of variables declaration//GEN-END:variables
}
