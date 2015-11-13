package ui;

import audio.Album;
import butterfly.AudioPlayer;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author natec
 */
public class AlbumEditor extends javax.swing.JFrame {

    private final Album album;
    private final AudioPlayer player;
    
    public AlbumEditor(AudioPlayer player, Album album) {
        this.player = player;
        this.album = album;
        
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
        
        this.ArtistField.setText(album.getArtist());
        this.NameField.setText(album.getName());
        this.GenreField.setText(album.getGenre());
        this.YearField.setText(Integer.toString(album.getYear()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AlbumNameLabel = new javax.swing.JLabel();
        ArtistLabel = new javax.swing.JLabel();
        GenreLabel = new javax.swing.JLabel();
        YearLabel = new javax.swing.JLabel();
        OkButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        NameField = new javax.swing.JFormattedTextField();
        ArtistField = new javax.swing.JFormattedTextField();
        GenreField = new javax.swing.JFormattedTextField();
        YearField = new javax.swing.JFormattedTextField(NumberFormat.getIntegerInstance());

        setResizable(false);

        AlbumNameLabel.setText("Album Name:");

        ArtistLabel.setText("Artist:");

        GenreLabel.setText("Genre:");

        YearLabel.setText("Year:");

        OkButton.setText("Ok");
        OkButton.setPreferredSize(new java.awt.Dimension(65, 23));
        OkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        NameField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        ArtistField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        GenreField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        YearField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

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
                            .addComponent(GenreLabel)
                            .addComponent(YearLabel)
                            .addComponent(AlbumNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameField)
                            .addComponent(YearField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(GenreField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ArtistField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlbumNameLabel)
                    .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArtistLabel)
                    .addComponent(ArtistField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        if (year > 0)
        {
            this.player.getLibrary().updateAlbumArtist(
                this.album,
                this.NameField.getText(),
                this.ArtistField.getText(),
                this.GenreField.getText(),            
                year
            );
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Error, year must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_OkButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlbumNameLabel;
    private javax.swing.JFormattedTextField ArtistField;
    private javax.swing.JLabel ArtistLabel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JFormattedTextField GenreField;
    private javax.swing.JLabel GenreLabel;
    private javax.swing.JFormattedTextField NameField;
    private javax.swing.JButton OkButton;
    private javax.swing.JFormattedTextField YearField;
    private javax.swing.JLabel YearLabel;
    // End of variables declaration//GEN-END:variables
}
