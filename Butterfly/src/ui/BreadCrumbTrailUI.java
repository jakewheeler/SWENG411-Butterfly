package ui;

import butterfly.BreadCrumbTrail;
import butterfly.IAudioController;

/**
 *
 * @author natec
 */
public class BreadCrumbTrailUI extends javax.swing.JPanel implements IAudioUI
{
    private BreadCrumbTrail controller;
    /**
     * Creates new form BreadCrumbTrailUI
     */
    public BreadCrumbTrailUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
      
    @Override
    public void setController(IAudioController controller)
    {
        this.controller = (BreadCrumbTrail) controller;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
