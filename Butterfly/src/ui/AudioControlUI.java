package ui;

import butterfly.AudioControl;
import butterfly.AudioPlayer;
import butterfly.IAudioController;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jake
 */
public class AudioControlUI extends javax.swing.JPanel implements IAudioUI 
{
    private AudioControl controller;
    private Icon pauseIMG;
    private Icon playIMG;
    
    public AudioControlUI()
    {        
        initComponents();
        
        SongLabel.setText(" ");
        ArtistLabel.setText(" ");
        AlbumLabel.setText(" ");
        try
        {
            pauseIMG = new ImageIcon(getClass().getClassLoader().getResource("resources/pause.PNG"));
            playIMG = new ImageIcon(getClass().getClassLoader().getResource("resources/play.PNG"));
        }
        catch(Exception ex){
            AudioPlayer.HandleException(ex);
        }        
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

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1366, 100));

        PlayPauseButton.setBackground(new java.awt.Color(51, 51, 51));
        PlayPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/play.PNG"))); // NOI18N
        PlayPauseButton.setMaximumSize(new java.awt.Dimension(58, 33));
        PlayPauseButton.setMinimumSize(new java.awt.Dimension(58, 33));
        PlayPauseButton.setPreferredSize(new java.awt.Dimension(58, 33));
        PlayPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayPauseButtonActionPerformed(evt);
            }
        });

        SongLabel.setBackground(new java.awt.Color(255, 255, 255));
        SongLabel.setForeground(new java.awt.Color(255, 255, 255));
        SongLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SongLabel.setText("songName");

        ArtistLabel.setBackground(new java.awt.Color(255, 255, 255));
        ArtistLabel.setForeground(new java.awt.Color(255, 255, 255));
        ArtistLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ArtistLabel.setText("artist");

        AlbumLabel.setBackground(new java.awt.Color(255, 255, 255));
        AlbumLabel.setForeground(new java.awt.Color(255, 255, 255));
        AlbumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AlbumLabel.setText("album");

        NextButton.setBackground(new java.awt.Color(51, 51, 51));
        NextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/right.PNG"))); // NOI18N
        NextButton.setMaximumSize(new java.awt.Dimension(58, 33));
        NextButton.setMinimumSize(new java.awt.Dimension(58, 33));
        NextButton.setPreferredSize(new java.awt.Dimension(58, 33));
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(51, 51, 51));
        BackButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left.png"))); // NOI18N
        BackButton.setMaximumSize(new java.awt.Dimension(58, 33));
        BackButton.setMinimumSize(new java.awt.Dimension(58, 33));
        BackButton.setPreferredSize(new java.awt.Dimension(58, 33));
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ShuffleButton.setBackground(new java.awt.Color(51, 51, 51));
        ShuffleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/shuffle.PNG"))); // NOI18N
        ShuffleButton.setMaximumSize(new java.awt.Dimension(58, 33));
        ShuffleButton.setMinimumSize(new java.awt.Dimension(58, 33));
        ShuffleButton.setPreferredSize(new java.awt.Dimension(58, 33));
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
        VolumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeSliderStateChanged(evt);
            }
        });

        repeatButton.setBackground(new java.awt.Color(51, 51, 51));
        repeatButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/repeat.PNG"))); // NOI18N
        repeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatButtonActionPerformed(evt);
            }
        });

        SongStartLabel.setBackground(new java.awt.Color(255, 255, 255));
        SongStartLabel.setForeground(new java.awt.Color(255, 255, 255));
        SongStartLabel.setText("00:00");

        SongEndLabel.setBackground(new java.awt.Color(255, 255, 255));
        SongEndLabel.setForeground(new java.awt.Color(255, 255, 255));
        SongEndLabel.setText("00:00");

        ClearQueueButton.setBackground(new java.awt.Color(51, 51, 51));
        ClearQueueButton.setForeground(new java.awt.Color(255, 255, 255));
        ClearQueueButton.setText("Clear Queue");
        ClearQueueButton.setPreferredSize(new java.awt.Dimension(58, 33));
        ClearQueueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearQueueButtonActionPerformed(evt);
            }
        });

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
                        .addGap(0, 483, Short.MAX_VALUE)
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
                        .addGap(283, 283, 283)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(NextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlayPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(repeatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ShuffleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(VolumeSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ClearQueueButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        try
        {
            PlayPauseButton.setIcon(pauseIMG); 
        }
        catch(Exception ex){
            AudioPlayer.HandleException(ex);
        }        
    }//GEN-LAST:event_BackButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        this.controller.next();
        try
        {
            PlayPauseButton.setIcon(pauseIMG);  
        }
        catch(Exception ex){
            AudioPlayer.HandleException(ex);
        }
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
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JToggleButton repeatButton;
    // End of variables declaration//GEN-END:variables
}
