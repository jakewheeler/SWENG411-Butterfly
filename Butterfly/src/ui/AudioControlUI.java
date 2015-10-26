package ui;

import butterfly.AudioControl;
import butterfly.IAudioController;

/**
 *
 * @author Jake
 */
public class AudioControlUI extends javax.swing.JPanel implements IAudioUI 
{
    private AudioControl controller;
    
    public AudioControlUI(AudioControl acController) 
    {
        initComponents();
        this.controller = acController;
        
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
        NextButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        ShuffleButton = new javax.swing.JButton();
        RepeatButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(420, 200));

        PlayPauseButton.setText("Play");
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });

        SongLabel.setText("songName");

        ArtistLabel.setText("artist");

        AlbumLabel.setText("album");

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ShuffleButton.setText("Shuffle");
        ShuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShuffleButtonActionPerformed(evt);
            }
        });

        RepeatButton.setText("Repeat");
        RepeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepeatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RepeatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ShuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ArtistLabel)
                    .addComponent(SongLabel)
                    .addComponent(AlbumLabel))
                .addGap(184, 184, 184))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlayPauseButton)
                    .addComponent(NextButton)
                    .addComponent(BackButton)
                    .addComponent(ShuffleButton)
                    .addComponent(RepeatButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PlayPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseButtonActionPerformed
        if (controller.isPlaying())
        {
          controller.pause();
          PlayPauseButton.setText("Play");
        }
        else
        {
            if (SongLabel.getText().equals("songName"))
            {
                setAllLabels();
                setAllLabelsVisibility(true);
            }
            controller.play();
            PlayPauseButton.setText("Pause");
        }
            
    }//GEN-LAST:event_PlayPauseButtonActionPerformed

    private void RepeatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepeatButtonActionPerformed
        this.controller.repeat();
    }//GEN-LAST:event_RepeatButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.controller.previous();
        this.setAllLabels();
        PlayPauseButton.setText("Pause");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        this.controller.next();
        this.setAllLabels();
        PlayPauseButton.setText("Pause");
    }//GEN-LAST:event_NextButtonActionPerformed

    private void ShuffleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShuffleButtonActionPerformed
        this.controller.shuffle();
    }//GEN-LAST:event_ShuffleButtonActionPerformed

    private void setAllLabels()
    {
        this.SongLabel.setText(controller.getCurrentSong());
        this.ArtistLabel.setText(controller.getCurrentArtist());
        this.AlbumLabel.setText(controller.getCurrentAlbum());
    }
    
    private void setAllLabelsVisibility(boolean bool)
    {
        this.SongLabel.setVisible(bool);
        this.ArtistLabel.setVisible(bool);
        this.AlbumLabel.setVisible(bool);
    }
    
    @Override
    public void setController(IAudioController controller)
    {
        this.controller = (AudioControl) controller;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumLabel;
    private javax.swing.JLabel ArtistLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PlayPauseButton;
    private javax.swing.JButton RepeatButton;
    private javax.swing.JButton ShuffleButton;
    private javax.swing.JLabel SongLabel;
    // End of variables declaration//GEN-END:variables
}
