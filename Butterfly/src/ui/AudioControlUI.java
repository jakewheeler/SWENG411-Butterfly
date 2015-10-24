package ui;

import butterfly.AudioControl;

/**
 *
 * @author Jake
 */
public class AudioControlUI extends javax.swing.JPanel {

    AudioControl acController;
    public AudioControlUI(AudioControl acController) 
    {
        initComponents();
        this.acController = acController;
        
        SongLabel.setVisible(false);
        ArtistLabel.setVisible(false);
        AlbumLabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayPauseButton = new javax.swing.JButton();
        SongLabel = new javax.swing.JLabel();
        ArtistLabel = new javax.swing.JLabel();
        AlbumLabel = new javax.swing.JLabel();

        PlayPauseButton.setText("Play");
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });

        SongLabel.setText("songName");

        ArtistLabel.setText("artist");

        AlbumLabel.setText("album");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PlayPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ArtistLabel)
                        .addComponent(SongLabel)
                        .addComponent(AlbumLabel)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SongLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArtistLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AlbumLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(PlayPauseButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PlayPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseButtonActionPerformed
        if (acController.isPlaying())
        {
          acController.pause();
          PlayPauseButton.setText("Play");
        }
        else
        {
            if (SongLabel.getText().equals("songName"))
            {
                setAllLabels();
                setAllLabelsVisibility(true);
            }
            acController.play();
            PlayPauseButton.setText("Pause");
        }
            
    }//GEN-LAST:event_PlayPauseButtonActionPerformed

    private void setAllLabels()
    {
        this.SongLabel.setText(acController.getCurrentSong());
        this.ArtistLabel.setText(acController.getCurrentArtist());
        this.AlbumLabel.setText(acController.getCurrentAlbum());
    }
    
    private void setAllLabelsVisibility(boolean bool)
    {
        this.SongLabel.setVisible(bool);
        this.ArtistLabel.setVisible(bool);
        this.AlbumLabel.setVisible(bool);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumLabel;
    private javax.swing.JLabel ArtistLabel;
    private javax.swing.JButton PlayPauseButton;
    private javax.swing.JLabel SongLabel;
    // End of variables declaration//GEN-END:variables
}
