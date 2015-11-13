package ui;

import butterfly.IAudioController;
import butterfly.TwitterHelper;
import java.awt.Color;
import java.awt.event.WindowEvent;

/**
 *
 * @author Jake
 */
public class TwitterHelperUI extends javax.swing.JDialog implements IAudioUI
{

    private TwitterHelper controller;
    
    public TwitterHelperUI(java.awt.Frame parent, boolean modal) 
    {
        super(parent, modal);
        initComponents();
        this.getContentPane().setBackground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EnterPinLabel = new javax.swing.JLabel();
        PINEntryTextField = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        InstructionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        EnterPinLabel.setBackground(new java.awt.Color(0, 0, 0));
        EnterPinLabel.setForeground(new java.awt.Color(255, 255, 255));
        EnterPinLabel.setText("Enter PIN:");

        PINEntryTextField.setBackground(new java.awt.Color(51, 51, 51));
        PINEntryTextField.setForeground(new java.awt.Color(255, 255, 255));
        PINEntryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PINEntryTextFieldActionPerformed(evt);
            }
        });

        OKButton.setBackground(new java.awt.Color(51, 51, 51));
        OKButton.setForeground(new java.awt.Color(255, 255, 255));
        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        InstructionLabel.setBackground(new java.awt.Color(0, 0, 0));
        InstructionLabel.setForeground(new java.awt.Color(255, 255, 255));
        InstructionLabel.setText("Enter the PIN given to you by Twitter and hit the OK button to continue.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(InstructionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PINEntryTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(EnterPinLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(OKButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(InstructionLabel)
                .addGap(28, 28, 28)
                .addComponent(EnterPinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PINEntryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OKButton)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PINEntryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PINEntryTextFieldActionPerformed

    }//GEN-LAST:event_PINEntryTextFieldActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKButtonActionPerformed
        controller.setUI(this);
        controller.getPinFromUser();
        
        // if the PIN is good, the PIN form closes and the tweet template appears
        if (controller.getPinStatus())
        {
           this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
           controller.createTweetTemplate(); 
        }
        // otherwise, the user gets an error and then the PIN window will close.
        else
        {
          this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        
    }//GEN-LAST:event_OKButtonActionPerformed

    @Override
    public void setController(IAudioController controller)
    {
        this.controller = (TwitterHelper) controller;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EnterPinLabel;
    private javax.swing.JLabel InstructionLabel;
    public javax.swing.JButton OKButton;
    public javax.swing.JTextField PINEntryTextField;
    // End of variables declaration//GEN-END:variables
}
