package ui;

import butterfly.IAudioController;
import butterfly.SongBrowser;

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LibraryTableScrollPane = new javax.swing.JScrollPane();
        LibraryTable = new javax.swing.JTable();
        SearchLibraryLabel = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));

        LibraryTableScrollPane.setBackground(new java.awt.Color(0, 0, 0));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LibraryTableScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SearchLibraryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 976, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchLibraryLabel)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        String words = this.SearchField.getText();
        this.controller.search(words);
    }//GEN-LAST:event_SearchFieldKeyReleased
    
    @Override
    public void setController(IAudioController controller)
    {
        this.controller = (SongBrowser) controller;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable LibraryTable;
    private javax.swing.JScrollPane LibraryTableScrollPane;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel SearchLibraryLabel;
    // End of variables declaration//GEN-END:variables
}
