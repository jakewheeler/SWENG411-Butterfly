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
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
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

        AudioControlUI = new ui.AudioControlUI();
        LibrarySplitter = new javax.swing.JSplitPane();
        LibraryBrowserUI = new ui.LibraryBrowserUI();
        SongBrowserUI = new ui.SongBrowserUI();
        FileMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        AddFilePathItem = new javax.swing.JMenuItem();
        ReauthTwitterItem = new javax.swing.JMenuItem();
        ExitItem = new javax.swing.JMenuItem();

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

        AudioControlUI.setMaximumSize(new java.awt.Dimension(32767, 100));
        AudioControlUI.setMinimumSize(new java.awt.Dimension(0, 100));
        AudioControlUI.setPreferredSize(new java.awt.Dimension(1280, 100));

        LibrarySplitter.setPreferredSize(new java.awt.Dimension(720, 400));

        LibraryBrowserUI.setMinimumSize(new java.awt.Dimension(50, 23));
        LibrarySplitter.setLeftComponent(LibraryBrowserUI);
        LibrarySplitter.setRightComponent(SongBrowserUI);

        FileMenu.setText("File");

        AddFilePathItem.setText("Add Music Folder");
        AddFilePathItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFilePathItemActionPerformed(evt);
            }
        });
        FileMenu.add(AddFilePathItem);

        ReauthTwitterItem.setText("Reauthenticate Twitter");
        ReauthTwitterItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReauthTwitterItemMousePressed(evt);
            }
        });
        FileMenu.add(ReauthTwitterItem);

        ExitItem.setText("Exit");
        ExitItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExitItemMousePressed(evt);
            }
        });
        FileMenu.add(ExitItem);

        FileMenuBar.add(FileMenu);

        setJMenuBar(FileMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LibrarySplitter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AudioControlUI, javax.swing.GroupLayout.DEFAULT_SIZE, 1433, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LibrarySplitter, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AudioControlUI, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.controller.closing();
    }//GEN-LAST:event_formWindowClosing

    private void ReauthTwitterItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReauthTwitterItemMousePressed
        this.controller.getTwitterHelper().clearTwitterFile();
    }//GEN-LAST:event_ReauthTwitterItemMousePressed

    private void ExitItemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitItemMousePressed
        System.exit(0);
    }//GEN-LAST:event_ExitItemMousePressed

    private void AddFilePathItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFilePathItemActionPerformed
        this.controller.addMusicFolder();
    }//GEN-LAST:event_AddFilePathItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddFilePathItem;
    public ui.AudioControlUI AudioControlUI;
    private javax.swing.JMenuItem ExitItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuBar FileMenuBar;
    public ui.LibraryBrowserUI LibraryBrowserUI;
    private javax.swing.JSplitPane LibrarySplitter;
    private javax.swing.JMenuItem ReauthTwitterItem;
    public ui.SongBrowserUI SongBrowserUI;
    // End of variables declaration//GEN-END:variables
}
