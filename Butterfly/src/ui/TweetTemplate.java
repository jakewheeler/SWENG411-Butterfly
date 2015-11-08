package ui;

import butterfly.TwitterHelper;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.TwitterException;

/**
 *
 * @author natec
 */
public class TweetTemplate extends javax.swing.JDialog 
{
    private final TwitterHelper twitterHelper;
    
    public TweetTemplate(TwitterHelper twitterHelper, java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
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
        } catch (Exception ex) {}
        //</editor-fold>
        initComponents();
        this.twitterHelper = twitterHelper;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EnterMessageLabel = new javax.swing.JLabel();
        TweetScrollPane = new javax.swing.JScrollPane();
        TweetTextArea = new javax.swing.JTextArea();
        CancelButton = new javax.swing.JButton();
        SendTweetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(518, 353));
        setMinimumSize(new java.awt.Dimension(518, 353));
        setResizable(false);

        EnterMessageLabel.setText("Share what you're currently listening to on Twitter");

        TweetTextArea.setBackground(new java.awt.Color(51, 51, 51));
        TweetTextArea.setColumns(20);
        TweetTextArea.setForeground(new java.awt.Color(255, 255, 255));
        TweetTextArea.setLineWrap(true);
        TweetTextArea.setRows(5);
        TweetTextArea.setWrapStyleWord(true);
        TweetScrollPane.setViewportView(TweetTextArea);

        CancelButton.setBackground(new java.awt.Color(51, 51, 51));
        CancelButton.setForeground(new java.awt.Color(255, 255, 255));
        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        SendTweetButton.setBackground(new java.awt.Color(51, 51, 51));
        SendTweetButton.setForeground(new java.awt.Color(255, 255, 255));
        SendTweetButton.setText("Post Tweet");
        SendTweetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendTweetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TweetScrollPane))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(SendTweetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(EnterMessageLabel)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(EnterMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TweetScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(SendTweetButton))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendTweetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendTweetButtonActionPerformed

        // sends the tweet out
        try {
            twitterHelper.sendTweet(this);
        } catch (TwitterException ex) {
            Logger.getLogger(TweetTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SendTweetButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        // lets the user cancel the tweet
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); // close the form
    }//GEN-LAST:event_CancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton CancelButton;
    private javax.swing.JLabel EnterMessageLabel;
    public javax.swing.JButton SendTweetButton;
    private javax.swing.JScrollPane TweetScrollPane;
    public javax.swing.JTextArea TweetTextArea;
    // End of variables declaration//GEN-END:variables
}
