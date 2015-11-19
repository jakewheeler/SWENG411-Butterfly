package tools;

import audio.Song;
import butterfly.AudioPlayer;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author natec
 */
public class SongEditor extends javax.swing.JFrame {

    private final Song song;
    public SongEditor(Song song) {
        this.song = song;
        this.getContentPane().setBackground(ColorSelections.getUIBackgroundColor());
        
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
        
        this.AlbumField.setText(song.getAlbum());
        this.ArtistField.setText(song.getArtist());
        this.SongField.setText(song.getSongName());
        this.GenreField.setText(song.getGenre());
        this.YearField.setText(Integer.toString(song.getYear()));
        this.NumberField.setText(Integer.toString(song.getNumberOnAlbum()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SongNameLabel = new javax.swing.JLabel();
        ArtistLabel = new javax.swing.JLabel();
        AlbumLabel = new javax.swing.JLabel();
        GenreLabel = new javax.swing.JLabel();
        YearLabel = new javax.swing.JLabel();
        TrackNumberLabel = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        SongField = new javax.swing.JFormattedTextField();
        ArtistField = new javax.swing.JFormattedTextField();
        AlbumField = new javax.swing.JFormattedTextField();
        GenreField = new javax.swing.JFormattedTextField();
        YearField = new javax.swing.JFormattedTextField(NumberFormat.getIntegerInstance());
        NumberField = new javax.swing.JFormattedTextField(NumberFormat.getIntegerInstance());

        setResizable(false);

        SongNameLabel.setBackground(ColorSelections.getUIBackgroundColor());
        SongNameLabel.setForeground(ColorSelections.getUILabelColor());
        SongNameLabel.setText("Song Name:");

        ArtistLabel.setBackground(ColorSelections.getUIBackgroundColor());
        ArtistLabel.setForeground(ColorSelections.getUILabelColor());
        ArtistLabel.setText("Artist:");

        AlbumLabel.setBackground(ColorSelections.getUIBackgroundColor());
        AlbumLabel.setForeground(ColorSelections.getUILabelColor());
        AlbumLabel.setText("Album:");

        GenreLabel.setBackground(ColorSelections.getUIBackgroundColor());
        GenreLabel.setForeground(ColorSelections.getUILabelColor());
        GenreLabel.setText("Genre:");

        YearLabel.setBackground(ColorSelections.getUIBackgroundColor());
        YearLabel.setForeground(ColorSelections.getUILabelColor());
        YearLabel.setText("Year:");

        TrackNumberLabel.setBackground(ColorSelections.getUIBackgroundColor());
        TrackNumberLabel.setForeground(ColorSelections.getUILabelColor());
        TrackNumberLabel.setText("#:");

        OkButton.setBackground(ColorSelections.getUIButtonColor());
        OkButton.setForeground(ColorSelections.getUIButtonTextColor());
        OkButton.setText("OK");
        OkButton.setPreferredSize(new java.awt.Dimension(65, 23));
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setBackground(ColorSelections.getUIButtonColor());
        CancelButton.setForeground(ColorSelections.getUIButtonTextColor());
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        SongField.setBackground(ColorSelections.getUITextFieldColor());
        SongField.setForeground(ColorSelections.getUITextFieldFontColor());
        SongField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        ArtistField.setBackground(ColorSelections.getUITextFieldColor());
        ArtistField.setForeground(ColorSelections.getUITextFieldFontColor());
        ArtistField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        AlbumField.setBackground(ColorSelections.getUITextFieldColor());
        AlbumField.setForeground(ColorSelections.getUITextFieldFontColor());
        AlbumField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        GenreField.setBackground(ColorSelections.getUITextFieldColor());
        GenreField.setForeground(ColorSelections.getUITextFieldFontColor());
        GenreField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        YearField.setBackground(ColorSelections.getUITextFieldColor());
        YearField.setForeground(ColorSelections.getUITextFieldFontColor());
        YearField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        NumberField.setBackground(ColorSelections.getUITextFieldColor());
        NumberField.setForeground(ColorSelections.getUITextFieldFontColor());
        NumberField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ArtistLabel)
                            .addComponent(AlbumLabel)
                            .addComponent(GenreLabel)
                            .addComponent(YearLabel)
                            .addComponent(TrackNumberLabel)
                            .addComponent(SongNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SongField)
                            .addComponent(YearField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GenreField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AlbumField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ArtistField)
                            .addComponent(NumberField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SongNameLabel)
                    .addComponent(SongField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArtistLabel)
                    .addComponent(ArtistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlbumLabel)
                    .addComponent(AlbumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenreLabel)
                    .addComponent(GenreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(YearLabel)
                    .addComponent(YearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TrackNumberLabel)
                    .addComponent(NumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void OkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkButtonActionPerformed
        int year = Integer.parseInt(this.YearField.getText().replace(",", "").replace(".", ""));
        int track = Integer.parseInt(this.NumberField.getText().replace(",", "").replace(".", ""));
        
        if (year > 0 && track > 0)
        {
            this.song.updateSong(
                this.SongField.getText(),
                this.ArtistField.getText(),
                this.AlbumField.getText(),
                this.GenreField.getText(),
                year,
                track
            );
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Error, year and track must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_OkButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField AlbumField;
    private javax.swing.JLabel AlbumLabel;
    private javax.swing.JFormattedTextField ArtistField;
    private javax.swing.JLabel ArtistLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JFormattedTextField GenreField;
    private javax.swing.JLabel GenreLabel;
    private javax.swing.JFormattedTextField NumberField;
    private javax.swing.JButton OkButton;
    private javax.swing.JFormattedTextField SongField;
    private javax.swing.JLabel SongNameLabel;
    private javax.swing.JLabel TrackNumberLabel;
    private javax.swing.JFormattedTextField YearField;
    private javax.swing.JLabel YearLabel;
    // End of variables declaration//GEN-END:variables
}
