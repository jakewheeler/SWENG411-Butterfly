package ui;

import tools.SongModel;
import butterfly.IAudioController;
import butterfly.SongBrowser;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import tools.ColorSelections;

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
        LibraryTableScrollPane.getViewport().setBackground(ColorSelections.getTableBackgroundColor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LibraryTableScrollPane = new javax.swing.JScrollPane();
        LibraryTable = new javax.swing.JTable();
        SearchLibraryLabel = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(700, 400));

        LibraryTableScrollPane.setBackground(new java.awt.Color(0, 0, 0));

        LibraryTable.setAutoCreateRowSorter(true);
        LibraryTable.setBackground(new java.awt.Color(51, 51, 51));
        LibraryTable.setForeground(new java.awt.Color(255, 255, 255));
        LibraryTable.setModel(new SongModel());
        LibraryTable.setFocusable(false);
        LibraryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LibraryTableMousePressed(evt);
            }
        });
        LibraryTableScrollPane.setViewportView(LibraryTable);
        LibraryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
            .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SearchLibraryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchLibraryLabel)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(LibraryTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SearchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFieldKeyReleased
        this.search(this.SearchField.getText());
    }//GEN-LAST:event_SearchFieldKeyReleased

    private void LibraryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LibraryTableMousePressed
        if (evt.getButton() == MouseEvent.BUTTON3)
        {
            this.controller.rightClick(evt.getPoint());
        }
        else if (evt.getClickCount() == 2)
        {
            this.controller.highlight(evt.getPoint());
            this.controller.playList();
        }
        this.controller.refreshModel();
    }//GEN-LAST:event_LibraryTableMousePressed
    
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
    public javax.swing.JTable LibraryTable;
    private javax.swing.JScrollPane LibraryTableScrollPane;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel SearchLibraryLabel;
    // End of variables declaration//GEN-END:variables
}
