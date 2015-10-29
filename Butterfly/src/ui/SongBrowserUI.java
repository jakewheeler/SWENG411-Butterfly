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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void setController(IAudioController controller)
    {
        this.controller = (SongBrowser) controller;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable LibraryTable;
    private javax.swing.JScrollPane LibraryTableScrollPane;
    // End of variables declaration//GEN-END:variables
}
