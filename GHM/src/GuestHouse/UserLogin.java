/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuestHouse;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abid Ali
 */
public class UserLogin extends javax.swing.JFrame {
    ConnectDatabase con_obj=new ConnectDatabase();
    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet res;
    public boolean loggin;
 
    
    public UserLogin() {
       
        con=con_obj.EstablishCon();
        con_obj.EstablishCon();
        initComponents();
    }
         public void Close(){
             WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
             
         }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        passtxt = new javax.swing.JPasswordField();
        showpass = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("User name  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 65, -1));
        jPanel1.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 156, 28));

        jButton1.setText(" Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 308, 231, 31));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Password    : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 238, -1, -1));
        jPanel1.add(passtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 222, 156, 30));

        showpass.setText("show password");
        showpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpassActionPerformed(evt);
            }
        });
        jPanel1.add(showpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 254, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 43, 220, 41));

        jButton2.setBackground(new java.awt.Color(102, 153, 255));
        jButton2.setText("Forgot password Or New as Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 345, 231, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 15, 340, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        user ru=new user();
        ru.setVisible(true);
        Close();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpassActionPerformed
        if(showpass.isSelected()){
            passtxt.setEchoChar((char)0);
        }
        else{
            passtxt.setEchoChar('*');
        }
    }//GEN-LAST:event_showpassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String name=nametxt.getText();
        String pass=passtxt.getText();
        boolean b=false;
        String login="select * from User where username = '"+name+"' and userpassword = '"+pass+"' ";
        String id=null;
        String una=null;
        String pas=null;
        String na=null;
        try {
            pstmt=con.prepareStatement(login);
            res=pstmt.executeQuery();
            while(res.next()){
                id=res.getString("ID");
                na=res.getString("Name");
                una=res.getString("username");
                pas=res.getString("userpassword");

                b=true;

            }
            if(b==true){
                loggin=true;

                JOptionPane.showMessageDialog(null, "Account logged in successfully");
                ControlPanel cp=new ControlPanel(true);
                cp.setVisible(true);
                Close();
            }
            else{
                loggin=false;
                JOptionPane.showMessageDialog(null, "Inputs are wrong.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JPasswordField passtxt;
    private javax.swing.JCheckBox showpass;
    // End of variables declaration//GEN-END:variables
}
