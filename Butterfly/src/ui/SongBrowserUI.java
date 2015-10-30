package ui;

import butterfly.IAudioController;
import butterfly.SongBrowser;
import java.awt.Color;

/**
 *
 * @author natec
 */
public class SongBrowserUI extends javax.swing.JPanel implements IAudioUI
{
    private SongBrowser controller;

    public SongBrowserUI() {
        initComponents();
        LibraryTable.setVisible(true);
        LibraryTable.setShowGrid(true);
        LibraryTable.setShowHorizontalLines(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LibraryTableScrollPane = new javax.swing.JScrollPane();
        LibraryTable = new javax.swing.JTable();
        SearchLibraryLabel = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        BackToLibraryButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 0, 0));

        LibraryTableScrollPane.setBackground(new java.awt.Color(0, 0, 0));

        LibraryTable.setAutoCreateRowSorter(true);
        LibraryTable.setBackground(new java.awt.Color(51, 51, 51));
        LibraryTable.setForeground(new java.awt.Color(255, 255, 255));
        LibraryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Song", "Artist", "Album"
            }
        ));
        LibraryTableScrollPane.setViewportView(LibraryTable);
        if (LibraryTable.getColumnModel().getColumnCount() > 0) {
            LibraryTable.getColumnModel().getColumn(0).setResizable(false);
        }

        SearchLibraryLabel.setBackground(new java.awt.Color(255, 255, 255));
        SearchLibraryLabel.setForeground(new java.awt.Color(255, 255, 255));
        SearchLibraryLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        SearchLibraryLabel.setText("Search Library:");

        SearchField.setBackground(new java.awt.Color(51, 51, 51));
        SearchField.setForeground(new java.awt.Color(255, 255, 255));
        SearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFieldKeyReleased(evt);
            }
        });

        BackToLibraryButton.setText("Library");
        BackToLibraryButton.setBackground(new java.awt.Color(51, 51, 51));
        BackToLibraryButton.setForeground(Color.white);
        BackToLibraryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToLibraryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackToLibraryButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SearchLibraryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchLibraryLabel)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackToLibraryButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        this.search(this.SearchField.getText());
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void BackToLibraryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToLibraryButtonActionPerformed
        this.SearchField.setText("");
        this.search("");
    }//GEN-LAST:event_BackToLibraryButtonActionPerformed
    
    @Override
    public void setController(IAudioController controller)
    {
        this.controller = (SongBrowser) controller;
    }
    
    private void search(String words)
    {
        this.controller.search(words);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToLibraryButton;
    public javax.swing.JTable LibraryTable;
    private javax.swing.JScrollPane LibraryTableScrollPane;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel SearchLibraryLabel;
    // End of variables declaration//GEN-END:variables
}
