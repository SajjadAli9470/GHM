/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuestHouse;

/**
 *
 * @author Abid Ali
 */
public class AboutSoftware extends javax.swing.JFrame {

    /**
     * Creates new form AboutSoftware
     */
    public AboutSoftware() {
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

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 640, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("About Software");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 11, 376, 55));

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Guest House Managment v1.1.9");
        jTextField1.setEnabled(false);
        jTextField1.setFocusable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 320, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 13)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(51, 51, 51));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("SOFTWARE:\nJava Develpment Kit 1.8 with NetBeansIDE 8.2,Ucanaccess Driver to Store data as Database and MS Access is used to Store Data.\n...............................................................................................................................\nFEATURES:\nThis program will give information about all Guests with Durations Record and also maintain the Records of Administrations.\n...............................................................................................................................\nIMPLEMENTATION:\n\nSOFTWARE:\n•\tNetBeans IDE 8.2  \n\nHARDWARE:\n\nMinimum Hardware Configurations\n•\tMicrosoft Windows Vista SP1/Windows 7 Professional.\no\tProcessor: 800MHz Intel Pentium III or equivalent\no\tMemory: 512 MB\no\tDisk space: 750 MB of free disk space\n•\tUbuntu 9.10:\no\tProcessor: 800MHz Intel Pentium III or equivalent\no\tMemory: 512 MB\no\tDisk space: 650 MB of free disk space\n•\tMacintosh OS X 10.7 Intel:\no\tProcessor: Dual-Core Intel\no\tMemory: 2 GB\no\tDisk space: 650 MB of free disk space\n\nRecommended Hardware Configurations\n•\tMicrosoft Windows 7 Professional/Windows 8/Windows 8.2:\no\tProcessor: Intel Core i5 or equivalent\no\tMemory: 2 GB (32-bit), 4 GB (64-bit)\no\tDisk space: 1.5 GB of free disk space\n•\tUbuntu 15.04:\no\tProcessor: Intel Core i5 or equivalent\no\tMemory: 2 GB (32-bit), 4 GB (64-bit)\no\tDisk space: 1.5 GB of free disk space\n•\tOS X 10.10 Intel:\no\tProcessor: Dual-Core Intel\no\tMemory: 4 GB\no\tDisk space: 1.5 GB of free disk space\n");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 660, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AboutSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutSoftware.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutSoftware().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}