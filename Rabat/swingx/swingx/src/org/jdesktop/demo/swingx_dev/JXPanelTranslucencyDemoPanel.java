/*
 * JXPanelTranslucencyDemoPanel.java
 *
 * Created on April 12, 2005, 9:37 AM
 */

package org.jdesktop.demo.swingx_dev;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import org.jdesktop.demo.DemoPanel;

/**
 * Demonstrates translucency on a JXPanel.
 * @author  rbair
 */
public class JXPanelTranslucencyDemoPanel extends DemoPanel {
    
    /**
     * Creates new form JXPanelTranslucencyDemoPanel 
     */
    public JXPanelTranslucencyDemoPanel() {
        setName("JXPanel Translucency Demo");
        initComponents();
        setIcon(new ImageIcon(getClass().getResource("/org/jdesktop/demo/swingx/resources/logo.gif")));
    }

    public String getHtmlDescription() {
        return "<html>Demonstrates the ability to make a JXPanel transparent/translucent. All GUI components" +
                "are made translucent along with the panel, without having to change the alpha for individual " +
                "components .<br>Slide " +
                "the &quot;alpha&quot; slider to change alpha setting for the JXPanel, " +
                "which controls panel's translucency. In the demo, the alpha " +
                "defaults to 100, which is fully opaque. Note how the panel transitions smoothly, and " +
                "in real-time, between translucent and opaque.</html>";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        alphaSlider = new javax.swing.JSlider();
        Hashtable labels = new Hashtable();
        labels.put(0, new JLabel("Trans."));
        labels.put(100, new JLabel("Opaque"));
        alphaSlider.setLabelTable(labels);
        jXPanel1 = new org.jdesktop.swingx.JXPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jXTitledPanel1 = new org.jdesktop.swingx.JXTitledPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jXTitledPanel2 = new org.jdesktop.swingx.JXTitledPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        setBackground(javax.swing.UIManager.getDefaults().getColor("ScrollBar.thumb"));
        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel3.setText("Alpha (translucency)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 11);
        add(jLabel3, gridBagConstraints);

        alphaSlider.setBackground(new java.awt.Color(153, 153, 255));
        alphaSlider.setPaintLabels(true);
        alphaSlider.setValue(100);
        alphaSlider.setOpaque(false);
        alphaSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                alphaSliderStateChanged(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 12, 11, 11);
        add(alphaSlider, gridBagConstraints);

        jXPanel1.setLayout(new java.awt.GridBagLayout());

        jXPanel1.setOpaque(false);
        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(100);
        jXTitledPanel1.getContentContainer().setLayout(new java.awt.BorderLayout());

        jXTitledPanel1.setTitle("Master");
        jScrollPane1.setBorder(null);
        jScrollPane1.setViewportView(jTree1);

        jXTitledPanel1.getContentContainer().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jXTitledPanel1);

        jXTitledPanel2.getContentContainer().setLayout(new java.awt.GridBagLayout());

        jXTitledPanel2.setTitle("Detail");
        jLabel1.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        jXTitledPanel2.getContentContainer().add(jLabel1, gridBagConstraints);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 153;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 0, 0);
        jXTitledPanel2.getContentContainer().add(jTextField1, gridBagConstraints);

        jToggleButton1.setText("Lookup...");
        jToggleButton1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 5, 0, 0);
        jXTitledPanel2.getContentContainer().add(jToggleButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 0, 0);
        jXTitledPanel2.getContentContainer().add(jRadioButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 185;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 5, 11, 11);
        jXTitledPanel2.getContentContainer().add(jComboBox1, gridBagConstraints);

        jCheckBox1.setText("Send flyers");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 10, 0, 0);
        jXTitledPanel2.getContentContainer().add(jCheckBox1, gridBagConstraints);

        jLabel2.setText("Where did you hear about us?");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(7, 12, 11, 0);
        jXTitledPanel2.getContentContainer().add(jLabel2, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 12, 0, 0);
        jXTitledPanel2.getContentContainer().add(jRadioButton2, gridBagConstraints);

        jSplitPane1.setRightComponent(jXTitledPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jXPanel1.add(jSplitPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 11, 11);
        add(jXPanel1, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
//GEN-FIRST:event_jLayeredPane1ComponentResized
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-LAST:event_jLayeredPane1ComponentResized
// TODO add your handling code here://GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void alphaSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_alphaSliderStateChanged
        // The use of invoke later is not strictly necessary, except that changing
        // the alpha on an older PIII laptop resulted in a slightly jerky slider
        // control, as it was dragged. Pushing this to a separate thread helps smooth
        // that out.       
        SwingUtilities.invokeLater( new Runnable() { 
            public void run() {
                jXPanel1.setAlpha((float)((float)alphaSlider.getValue()/(float)100));
            }
        });
    }//GEN-LAST:event_alphaSliderStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider alphaSlider;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTree jTree1;
    private org.jdesktop.swingx.JXPanel jXPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel1;
    private org.jdesktop.swingx.JXTitledPanel jXTitledPanel2;
    // End of variables declaration//GEN-END:variables
    
}
