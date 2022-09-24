/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuestHouse;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Platform.exit;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abid Ali
 */
public class user extends javax.swing.JFrame {

    ConnectDatabase con_obj = new ConnectDatabase();
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res;
    DefaultTableModel d;

    public user() {

        con = con_obj.EstablishCon();
        con_obj.EstablishCon();
        initComponents();
        Loaduser();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        unametxt = new javax.swing.JTextField();
        addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        closebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        upasstxt = new javax.swing.JPasswordField();
        idtxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        athc = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 0), new java.awt.Color(102, 102, 0), new java.awt.Color(0, 102, 153), new java.awt.Color(51, 0, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 100, 179, -1));

        jLabel4.setText("Username");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 151, 179, -1));

        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 205, 179, -1));
        jPanel1.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 120, 179, -1));
        jPanel1.add(unametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 176, 179, -1));

        addbtn.setText("add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 315, 86, -1));

        editbtn.setText("edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });
        jPanel1.add(editbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 315, 87, -1));

        delbtn.setText("delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        jPanel1.add(delbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 349, 86, -1));

        clearbtn.setText("clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel1.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 349, 87, -1));

        closebtn.setText("Back to Login");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        jPanel1.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 378, 179, -1));

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Name", "UserName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 408, 366));
        jPanel1.add(upasstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 225, 179, -1));

        idtxt.setEditable(false);
        idtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idtxtActionPerformed(evt);
            }
        });
        jPanel1.add(idtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 74, 179, -1));

        jLabel6.setText("ID");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 54, 179, -1));

        jLabel7.setText("Authorized Code :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 252, 179, -1));
        jPanel1.add(athc, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 272, 179, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Admin's Record");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 20, 270, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void close() {
        WindowEvent WCE = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);

    }

    public void Loaduser() {
        int c;
        try {
            pstmt = con.prepareStatement("select * from User ");
            res = pstmt.executeQuery();
            ResultSetMetaData rsd = res.getMetaData();
            c = rsd.getColumnCount();
            d = (DefaultTableModel) userTable.getModel();
            d.setRowCount(0);
            while (res.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    v2.add(res.getString("ID"));
                    v2.add(res.getString("Name"));
                    v2.add(res.getString("username"));

                }
                d.addRow(v2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     private boolean isAnyRequiredFieldEmpty() {
        return nametxt.getText().equals("") || unametxt.getText().equals("") || upasstxt.getText().equals("");
    }
    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        try {
            String name = nametxt.getText();
            String uname = unametxt.getText();
            String upass = upasstxt.getText();
            boolean b = false;
    if(!isAnyRequiredFieldEmpty()){
            char[] pass = athc.getPassword();
            String final_pass = "";
            for (char x : pass) {
                final_pass += x;
            }
            String admin = "admin123";
            String ch = (final_pass);
            if (final_pass.equals(admin)) {
                b = true;

            } else {
                b = false;

            }
            if(b==true){
            String sql = "insert into User(Name,username,userpassword) values('" + name + "','" + uname + "','" + upass + "')";
            stmt = con.createStatement();
            int res = stmt.executeUpdate(sql);

//            JOptionPane.showMessageDialog(this, "user inserted.");
             nametxt.setText("");
            unametxt.setText("");
            upasstxt.setText("");
            Loaduser();}
            else{
                JOptionPane.showMessageDialog(this, "Missing any text field");
            }
            }else{
                 JOptionPane.showMessageDialog(this, "Invalid Authorized Code");
            }
           
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_addbtnActionPerformed

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        try {
            String id = idtxt.getText();
            String name = nametxt.getText();
            String uname = unametxt.getText();
            String upass = upasstxt.getText();
            boolean b;
 if(!isAnyRequiredFieldEmpty()){
            char[] pass = athc.getPassword();
            String final_pass = "";
            for (char x : pass) {
                final_pass += x;
            }
            String admin = "admin123";
            String ch = (final_pass);
            if (final_pass.equals(admin)) {
                b = true;

            } else {
                b = false;

            }
            if(b==true){
            String sql = "update User set Name ='" + name + "', username = '" + uname + "' , userpassword ='" + upass + "' where ID='" + id + "'";
            pstmt = con.prepareStatement(sql);

            int res = pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "profile Edited");

            nametxt.setText("");
            unametxt.setText("");
            upasstxt.setText("");
            Loaduser();}
            else{ JOptionPane.showMessageDialog(this, "Invalid Authorized Code");
                    
                    }
            
            
            }else{
                JOptionPane.showMessageDialog(this, "Missing any text field");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_editbtnActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        d = (DefaultTableModel) userTable.getModel();
        int selectIndex = userTable.getSelectedRow();
        String pass = null;

        idtxt.setText(d.getValueAt(selectIndex, 0).toString());
        String id = idtxt.getText();
        String getPass = "select userpassword from User where ID = '" + id + "' ";
        try {
            pstmt = con.prepareStatement(getPass);
            res = pstmt.executeQuery();
            while (res.next()) {
                pass = res.getString("userpassword");
            }
            System.out.println(pass);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        nametxt.setText(d.getValueAt(selectIndex, 1).toString());
        unametxt.setText(d.getValueAt(selectIndex, 2).toString());
        upasstxt.setText(pass);
        addbtn.setEnabled(false);


    }//GEN-LAST:event_userTableMouseClicked

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        nametxt.setText("");
        unametxt.setText("");
        upasstxt.setText("");
        Loaduser();
//           autoID();
        addbtn.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_clearbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        try {
            String id = idtxt.getText();
            String sql = "delete from User where ID='" + id + "' ";
            pstmt = con.prepareStatement(sql);

            int res = pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "user Deleted");

            nametxt.setText("");
            unametxt.setText("");
            upasstxt.setText("");
            Loaduser();
            addbtn.setEnabled(true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_delbtnActionPerformed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        UserLogin ul = new UserLogin();
        ul.setVisible(true);

        close();

        // TODO add your handling code here:
    }//GEN-LAST:event_closebtnActionPerformed

    private void idtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idtxtActionPerformed

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JPasswordField athc;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton delbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField unametxt;
    private javax.swing.JPasswordField upasstxt;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
