
package GuestHouse;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Rooms extends javax.swing.JFrame {
   ConnectDatabase con_obj=new ConnectDatabase();
   Connection con;
   Statement stmt = null;
   PreparedStatement pst = null;
   ResultSet res;
   DefaultTableModel d;
   
    public Rooms() {
        con=con_obj.EstablishCon();
        initComponents();
        con_obj.EstablishCon();
        Load_room();
        autoID();

    }

   public void Load_room(){
    int c;
       try {
           pst=con.prepareStatement("select * from Room ");
           res=pst.executeQuery();
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)RoomTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   v2.add(res.getString("rid"));
                   v2.add(res.getString("rtype"));
                   v2.add(res.getString("btype"));
                   
               }
               d.addRow(v2);
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
       }
    
   } 
    
    public void autoID(){
        String id=null;
        String query = "select max(rid) from Room";
    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
        System.out.println("here.......");
      while (rs.next()) {
        id = rs.getString(1);
      }
      if(id==null){
          ridtxt.setText("R0001");
      }
      else{
          long ID=Long.parseLong(id.substring(2,id.length()));
          ID++;
          ridtxt.setText("R0"+String.format("%03d",ID));
      }
    } catch (SQLException e) {
        System.out.println(e);
    }
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rtypecmb = new javax.swing.JComboBox<>();
        btypecmb = new javax.swing.JComboBox<>();
        ridtxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RoomTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        clearbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        savebutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 0), new java.awt.Color(153, 0, 255), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 0, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Room no");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 44, 70, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Room Type");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 100, 80, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Bed Type");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 150, -1, 30));

        rtypecmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "VIP" }));
        rtypecmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtypecmbActionPerformed(evt);
            }
        });
        jPanel1.add(rtypecmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 100, 80, 30));

        btypecmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "single", "double" }));
        btypecmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btypecmbActionPerformed(evt);
            }
        });
        jPanel1.add(btypecmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 80, 30));

        ridtxt.setEditable(false);
        ridtxt.setForeground(new java.awt.Color(0, 0, 204));
        ridtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ridtxtActionPerformed(evt);
            }
        });
        jPanel1.add(ridtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 47, 80, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, 220));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Room");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 160, 60));

        RoomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room no", "Room type", "bed type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        RoomTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RoomTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 310, 310));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 0, 204), new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clearbutton.setText("clear");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 60, -1));

        deletebutton.setText("delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 70, -1));

        editbutton.setText("edit");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });
        jPanel2.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 10, 60, -1));

        jButton1.setText("Back to Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 130, -1));

        savebutton.setText("save");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });
        jPanel2.add(savebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 270, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
       try {
        String roomno=ridtxt.getText();
        String roomtype= rtypecmb.getSelectedItem().toString();
        String bedtype=btypecmb.getSelectedItem().toString();
       
        String sql="insert into Room(rid,rtype,btype) values('"+roomno+"','"+roomtype+"','"+bedtype+"') ";
        stmt = con.createStatement();
       int res=stmt.executeUpdate(sql);
       
//           JOptionPane.showMessageDialog(this, "Room Added");
           
           ridtxt.setText("");
           rtypecmb.setSelectedIndex(-1);
           btypecmb.setSelectedIndex(-1);
          
           Load_room();
           autoID();
           // TODO add your handling code here:
       } catch (SQLException ex) {
           Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_savebuttonActionPerformed

    private void RoomTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomTableMouseClicked
        d=(DefaultTableModel)RoomTable.getModel();
        int selectIndex =RoomTable.getSelectedRow();
        
        ridtxt.setText(d.getValueAt(selectIndex, 0).toString());
        rtypecmb.setSelectedItem(d.getValueAt(selectIndex, 1).toString());
        btypecmb.setSelectedItem(d.getValueAt(selectIndex, 2).toString());
      
        savebutton.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomTableMouseClicked

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
         try {
        String roomno=ridtxt.getText();
        String roomtype= rtypecmb.getSelectedItem().toString();
        String bedtype=btypecmb.getSelectedItem().toString();
       
        String sql="update Room set rtype ='"+roomtype+"', btype = '"+bedtype+"'  where rid='"+roomno+"' ";
        pst = con.prepareStatement(sql);
        
       int res=pst.executeUpdate();
       
//           JOptionPane.showMessageDialog(null, "Room Edited");
           
           ridtxt.setText("");
           rtypecmb.setSelectedIndex(-1);
           btypecmb.setSelectedIndex(-1);
        
           Load_room();
           autoID();
           
           // TODO add your handling code here:
       } catch (SQLException ex) {
           Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
       } // TODO add your handling code here:
    }//GEN-LAST:event_editbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
           ridtxt.setText("");
           rtypecmb.setSelectedIndex(-1);
           btypecmb.setSelectedIndex(-1);
      
           Load_room();
           autoID();
           savebutton.setEnabled(true);
// TODO add your handling code here:
    }//GEN-LAST:event_clearbuttonActionPerformed
public void close(){
              WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
          }   
    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
               try {
        String roomno=ridtxt.getText();
        String sql="delete from room where rid='"+roomno+"' ";
        pst = con.prepareStatement(sql);
        
       int res=pst.executeUpdate();
      
//           JOptionPane.showMessageDialog(null, "Room Deleted");
           
           ridtxt.setText("");
           rtypecmb.setSelectedIndex(-1);
           btypecmb.setSelectedIndex(-1);
        
           Load_room();
           autoID();
           
           // TODO add your handling code here:
       } catch (SQLException ex) {
           Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
       } // TODO add your handling code here:
                                         
  // TODO add your handling code here:
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void ridtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ridtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ridtxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            ControlPanel cp=new ControlPanel(true);
             cp.setVisible(true);
             close();
             
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rtypecmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtypecmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rtypecmbActionPerformed

    private void btypecmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btypecmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btypecmbActionPerformed

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
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rooms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rooms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RoomTable;
    private javax.swing.JComboBox<String> btypecmb;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton editbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ridtxt;
    private javax.swing.JComboBox<String> rtypecmb;
    private javax.swing.JButton savebutton;
    // End of variables declaration//GEN-END:variables
}
