package ui;

import butterfly.AudioControl;
import butterfly.IAudioController;
import java.awt.Color;
import tools.ColorSelections;

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
        
        SongLabel.setText(" ");
        ArtistLabel.setText(" ");
        AlbumLabel.setText(" ");     
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
        SongLocationSlider = new javax.swing.JSlider();
        VolumeSlider = new javax.swing.JSlider();
        repeatButton = new javax.swing.JToggleButton();
        SongStartLabel = new javax.swing.JLabel();
        SongEndLabel = new javax.swing.JLabel();
        ClearQueueButton = new javax.swing.JButton();
        TwitterButtonControl = new tools.TwitterButton();
        TheGreatBigInvisibleButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1366, 100));

        PlayPauseButton.setBackground(ColorSelections.getUIButtonColor());
        PlayPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/play.PNG"))); // NOI18N
        PlayPauseButton.setMaximumSize(new java.awt.Dimension(58, 33));
        PlayPauseButton.setMinimumSize(new java.awt.Dimension(58, 33));
        PlayPauseButton.setPreferredSize(new java.awt.Dimension(75, 35));
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });

        SongLabel.setBackground(ColorSelections.getUILabelColor());
        SongLabel.setForeground(ColorSelections.getUILabelColor());
        SongLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SongLabel.setText("songName");

        ArtistLabel.setBackground(ColorSelections.getUILabelColor());
        ArtistLabel.setForeground(ColorSelections.getUILabelColor());
        ArtistLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ArtistLabel.setText("artist");

        AlbumLabel.setBackground(ColorSelections.getUILabelColor());
        AlbumLabel.setForeground(ColorSelections.getUILabelColor());
        AlbumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AlbumLabel.setText("album");

        NextButton.setBackground(ColorSelections.getUIButtonColor());
        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/right.PNG"))); // NOI18N
        NextButton.setMaximumSize(new java.awt.Dimension(58, 33));
        NextButton.setMinimumSize(new java.awt.Dimension(58, 33));
        NextButton.setPreferredSize(new java.awt.Dimension(75, 35));
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(ColorSelections.getUIButtonColor());
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left.png"))); // NOI18N
        BackButton.setMaximumSize(new java.awt.Dimension(58, 33));
        BackButton.setMinimumSize(new java.awt.Dimension(58, 33));
        BackButton.setPreferredSize(new java.awt.Dimension(75, 35));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ShuffleButton.setBackground(ColorSelections.getUIButtonColor());
        ShuffleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shuffle.PNG"))); // NOI18N
        ShuffleButton.setMaximumSize(new java.awt.Dimension(58, 33));
        ShuffleButton.setMinimumSize(new java.awt.Dimension(58, 33));
        ShuffleButton.setPreferredSize(new java.awt.Dimension(75, 35));
        ShuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShuffleButtonActionPerformed(evt);
            }
        });

        SongLocationSlider.setMaximum(1000);
        SongLocationSlider.setValue(0);
        SongLocationSlider.setPreferredSize(new java.awt.Dimension(20, 26));
        SongLocationSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SongLocationSliderMouseReleased(evt);
            }
        });

        VolumeSlider.setValue(100);
        VolumeSlider.setPreferredSize(new java.awt.Dimension(75, 35));
        VolumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeSliderStateChanged(evt);
            }
        });

        repeatButton.setBackground(new java.awt.Color(51, 51, 51));
        repeatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/repeat.PNG"))); // NOI18N
        repeatButton.setPreferredSize(new java.awt.Dimension(75, 35));
        repeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatButtonActionPerformed(evt);
            }
        });

        SongStartLabel.setBackground(ColorSelections.getUILabelColor());
        SongStartLabel.setForeground(ColorSelections.getUILabelColor());
        SongStartLabel.setText("00:00");

        SongEndLabel.setBackground(ColorSelections.getUILabelColor());
        SongEndLabel.setForeground(ColorSelections.getUILabelColor());
        SongEndLabel.setText("00:00");

        ClearQueueButton.setBackground(ColorSelections.getUIButtonColor());
        ClearQueueButton.setForeground(ColorSelections.getUIButtonTextColor());
        ClearQueueButton.setText("Clear Queue");
        ClearQueueButton.setPreferredSize(new java.awt.Dimension(75, 35));
        ClearQueueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearQueueButtonActionPerformed(evt);
            }
        });

        TwitterButtonControl.setPreferredSize(new java.awt.Dimension(75, 35));

        TheGreatBigInvisibleButton.setPreferredSize(new java.awt.Dimension(75, 35));
        TheGreatBigInvisibleButton.setBackground(Color.black);
        TheGreatBigInvisibleButton.setEnabled(false);
        TheGreatBigInvisibleButton.setForeground(Color.black);
        TheGreatBigInvisibleButton.setOpaque(false);
        TheGreatBigInvisibleButton.setContentAreaFilled(false);
        TheGreatBigInvisibleButton.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SongLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AlbumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ArtistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SongStartLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SongLocationSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SongEndLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(TwitterButtonControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addComponent(TheGreatBigInvisibleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                        .addComponent(ClearQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SongLabel)
                    .addComponent(AlbumLabel)
                    .addComponent(ArtistLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SongLocationSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SongEndLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SongStartLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TwitterButtonControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(repeatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(PlayPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ShuffleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VolumeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(ClearQueueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TheGreatBigInvisibleButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PlayPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayPauseButtonActionPerformed
        if (controller.isPlaying())
        {
            controller.pause();
        }
        else
        {
            controller.play();
        }
    }//GEN-LAST:event_PlayPauseButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        this.controller.previous();     
    }//GEN-LAST:event_BackButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        this.controller.next();
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
        this.controller.setDuration(this.SongLocationSlider.getValue());
    }//GEN-LAST:event_SongLocationSliderMouseReleased

    private void ClearQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearQueueButtonActionPerformed
        this.controller.clearQueue();
    }//GEN-LAST:event_ClearQueueButtonActionPerformed
        
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
    
    public void setSongStartLabel(String time)
    {
        this.SongStartLabel.setText(time);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel AlbumLabel;
    public javax.swing.JLabel ArtistLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ClearQueueButton;
    private javax.swing.JButton NextButton;
    public javax.swing.JButton PlayPauseButton;
    private javax.swing.JButton ShuffleButton;
    private javax.swing.JLabel SongEndLabel;
    public javax.swing.JLabel SongLabel;
    public javax.swing.JSlider SongLocationSlider;
    private javax.swing.JLabel SongStartLabel;
    private javax.swing.JButton TheGreatBigInvisibleButton;
    public tools.TwitterButton TwitterButtonControl;
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JToggleButton repeatButton;
    // End of variables declaration//GEN-END:variables
}
