package ui;

import audio.ArtistSongList;
import audio.ISongList;
import audio.PlayList;
import audio.Song;
import butterfly.AudioPlayer;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author natec
 */
public class PlayListMenu extends javax.swing.JFrame
{
    private final AudioPlayer player;
    private Song song;
    private ISongList list;
    
    public PlayListMenu(AudioPlayer player, Song song) {
        this.player = player;
        this.song = song;
        start();
    }
    
    public PlayListMenu(AudioPlayer player, ArtistSongList artist)
    {
        this.player = player;
        this.list = artist;
        start();
    }
    
    private void start()
    {
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
            java.util.logging.Logger.getLogger(PlayListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayListMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        initComponents();
        updateBox();        
    }
    
    @SuppressWarnings("unchecked")
    private void updateBox()
    {
        TreeMap<String, PlayList> playlists = player.getLibrary().getPlayListMap();
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.PlayListBox.getModel();
        model.removeAllElements();
        if(!playlists.isEmpty())
            playlists.entrySet().forEach(list -> {
                model.addElement(list.getKey());
            });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        PlayListField = new javax.swing.JTextField();
        NewPlayListButton = new javax.swing.JButton();
        PlayListBox = new javax.swing.JComboBox();
        AddSongButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Add PlayList:");

        PlayListField.setText("Enter Name Here");
        PlayListField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PlayListFieldMousePressed(evt);
            }
        });

        NewPlayListButton.setText("Add");
        NewPlayListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPlayListButtonActionPerformed(evt);
            }
        });

        PlayListBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));

        AddSongButton.setText("Add To List");
        AddSongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddSongButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayListField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewPlayListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PlayListBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AddSongButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PlayListField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewPlayListButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayListBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddSongButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddSongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddSongButtonActionPerformed
        if (song != null)
            this.player.addToPlayList((String) this.PlayListBox.getSelectedItem(), song);
        else
            this.player.addToPlayList((String) this.PlayListBox.getSelectedItem(), list);
        this.dispose();
    }//GEN-LAST:event_AddSongButtonActionPerformed

    private void PlayListFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayListFieldMousePressed
        this.PlayListField.selectAll();
    }//GEN-LAST:event_PlayListFieldMousePressed

    private void NewPlayListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewPlayListButtonActionPerformed
        this.player.addNewPlaylist(this.PlayListField.getText());
        this.updateBox();
    }//GEN-LAST:event_NewPlayListButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddSongButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton NewPlayListButton;
    private javax.swing.JComboBox PlayListBox;
    private javax.swing.JTextField PlayListField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
