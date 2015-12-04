package tools;

import butterfly.AudioPlayer;
import butterfly.TwitterHelper;

/**
 *
 * @author Jake
 */
public class TwitterButton extends javax.swing.JPanel
{
    private TwitterHelper controller;

    public TwitterButton() 
    {
        initComponents();
    }
    
    public void setTwitterHelper(TwitterHelper twitterHelper)
    {
        this.controller = twitterHelper;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TwitterButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        TwitterButton.setBackground(ColorSelections.UIButtonColor);
        TwitterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/twitterIconSmall.png"))); // NOI18N
        TwitterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwitterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TwitterButton)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TwitterButton)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TwitterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwitterButtonActionPerformed
        this.performTwitter();
    }//GEN-LAST:event_TwitterButtonActionPerformed

    private void performTwitter()
    {
        try {
            // start Twitter
            controller.startTwitter();            
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        
        // choose the correct credential method
        try {
            controller.setCredentialMethod();
        } catch (Exception ex) {
            AudioPlayer.HandleException(ex);
        }
        
        // if user has twitter file with credentials, use that
        if (controller.hasCredentialsStatus())
        {
            try {
                controller.useSavedCredentials();
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
            
            controller.createTweetTemplate();
        }
        // otherwise get new credentials (user has to enter pin this one time)
        else
        {
            
            try {
                // else get credentials
                controller.getNewCredentials();
            } catch (Exception ex) {
                AudioPlayer.HandleException(ex);
            }
            
            controller.createPinEntryForm();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton TwitterButton;
    // End of variables declaration//GEN-END:variables
}
