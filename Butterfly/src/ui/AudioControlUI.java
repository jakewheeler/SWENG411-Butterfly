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
    
    public AudioControlUI() 
    {
        
        initComponents();
        
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
        VolumeSlider = new javax.swing.JSlider();
        repeatButton = new javax.swing.JToggleButton();
        SongStartLabel = new javax.swing.JLabel();
        SongEndLabel = new javax.swing.JLabel();
        SongLocationSlider = new javax.swing.JSlider();

        setPreferredSize(new java.awt.Dimension(1279, 150));

        PlayPauseButton.setText("Play");
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });

        SongLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SongLabel.setText("songName");

        ArtistLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArtistLabel.setText("artist");

        AlbumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        VolumeSlider.setValue(100);
        VolumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeSliderStateChanged(evt);
            }
        });

        repeatButton.setText("Repeat");
        repeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatButtonActionPerformed(evt);
            }
        });

        SongStartLabel.setText("0:00");

        SongEndLabel.setText("99:99");

        SongLocationSlider.setMaximum(1000);
        SongLocationSlider.setValue(0);
        SongLocationSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SongLocationSliderMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(SongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(ArtistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(AlbumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(440, 440, 440)
                        .addComponent(repeatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlayPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ShuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SongStartLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SongLocationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SongEndLabel)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SongLabel)
                    .addComponent(ArtistLabel)
                    .addComponent(AlbumLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SongStartLabel)
                        .addComponent(SongEndLabel))
                    .addComponent(SongLocationSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PlayPauseButton)
                        .addComponent(NextButton)
                        .addComponent(BackButton)
                        .addComponent(ShuffleButton)
                        .addComponent(repeatButton))
                    .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                setAllLabelsVisibility(true);
            }
            controller.play();
            PlayPauseButton.setText("Pause");
        }
    }//GEN-LAST:event_PlayPauseButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.controller.previous();
        PlayPauseButton.setText("Pause");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        this.controller.next();
        PlayPauseButton.setText("Pause");
    }//GEN-LAST:event_NextButtonActionPerformed

    private void ShuffleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShuffleButtonActionPerformed
        this.controller.shuffle();
    }//GEN-LAST:event_ShuffleButtonActionPerformed

    private void VolumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumeSliderStateChanged
        this.controller.setVolume(((double) this.VolumeSlider.getValue()) / 100);
    }//GEN-LAST:event_VolumeSliderStateChanged

    private void repeatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatButtonActionPerformed
        this.controller.repeat();
    }//GEN-LAST:event_repeatButtonActionPerformed

    private void SongLocationSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SongLocationSliderMouseReleased
        if (this.controller.isPlaying())
            this.controller.setDuration(this.SongLocationSlider.getValue() / 10);
    }//GEN-LAST:event_SongLocationSliderMouseReleased
    
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
        this.controller.setVolume(((double) this.VolumeSlider.getValue()) / 100);
    }
    
    public void setSongEndLabel(String time)
    {
        this.SongEndLabel.setText(time);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AlbumLabel;
    public javax.swing.JLabel ArtistLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PlayPauseButton;
    private javax.swing.JButton ShuffleButton;
    private javax.swing.JLabel SongEndLabel;
    public javax.swing.JLabel SongLabel;
    public javax.swing.JSlider SongLocationSlider;
    private javax.swing.JLabel SongStartLabel;
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JToggleButton repeatButton;
    // End of variables declaration//GEN-END:variables
}
