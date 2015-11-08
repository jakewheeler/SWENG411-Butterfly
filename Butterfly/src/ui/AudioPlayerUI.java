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

        AudioControlUI = new ui.AudioControlUI();
        jSplitPane1 = new javax.swing.JSplitPane();
        LibraryBrowserUI = new ui.LibraryBrowserUI();
        SongBrowserUI = new ui.SongBrowserUI();
        TwitterButtonControl = new ui.TwitterButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Butterfly");
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1366, 720));
        setPreferredSize(new java.awt.Dimension(1400, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        AudioControlUI.setMinimumSize(new java.awt.Dimension(0, 0));
        AudioControlUI.setPreferredSize(new java.awt.Dimension(1280, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 1345;
        gridBagConstraints.ipady = 133;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 6, 0);
        getContentPane().add(AudioControlUI, gridBagConstraints);

        jSplitPane1.setPreferredSize(new java.awt.Dimension(720, 400));

        LibraryBrowserUI.setMinimumSize(new java.awt.Dimension(50, 23));
        jSplitPane1.setLeftComponent(LibraryBrowserUI);
        jSplitPane1.setRightComponent(SongBrowserUI);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 995;
        gridBagConstraints.ipady = 334;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jSplitPane1, gridBagConstraints);
        getContentPane().add(TwitterButtonControl, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.controller.closing();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public ui.AudioControlUI AudioControlUI;
    public ui.LibraryBrowserUI LibraryBrowserUI;
    public ui.SongBrowserUI SongBrowserUI;
    public ui.TwitterButton TwitterButtonControl;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
