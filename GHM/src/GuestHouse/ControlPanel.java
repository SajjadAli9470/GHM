/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuestHouse;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Abid Ali
 */
public class ControlPanel extends javax.swing.JFrame {

    /**
     * Creates new form ControlPanel
     */
    public ControlPanel(){
        Close();
            }
    public ControlPanel(boolean b) {
        this.logIn=b;
        initComponents();
        
        login();
        
    }
//    public ControlPanel(boolean b){
//        this.logIn=b;
//        System.out.println(this.logIn);
//    }
  public  boolean logIn=false;
    public  void Close(){
             WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
             Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
             
         }
    public void login(){
        if(logIn==true){
            ImageIcon icon = new ImageIcon("src/images/sli.png");
            confirmLI.setSelected(true); 
            AdminReg.setIcon(icon);
            logout.setSelected(false);
//            image.setIcon(icon);
        }
        else{
            logout.setSelected(true);
            ImageIcon icon = new ImageIcon("src/images/slo.png");
            confirmLI.setSelected(false);
            AdminReg.setIcon(icon);
            
//            image.setIcon(icon);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AdminReg = new javax.swing.JButton();
        confirmLI = new javax.swing.JCheckBox();
        LT = new javax.swing.JButton();
        dcn = new javax.swing.JButton();
        abd = new javax.swing.JButton();
        abs = new javax.swing.JButton();
        guests = new javax.swing.JButton();
        rooms = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        logout = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 153, 255), new java.awt.Color(102, 102, 255), new java.awt.Color(0, 51, 255), new java.awt.Color(0, 102, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AdminReg.setText("Admin");
        AdminReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminRegActionPerformed(evt);
            }
        });
        jPanel1.add(AdminReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 110, 40));

        confirmLI.setText("Log In");
        confirmLI.setEnabled(false);
        jPanel1.add(confirmLI, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 70, 20));

        LT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout2.png"))); // NOI18N
        LT.setText(" ");
        LT.setBorderPainted(false);
        LT.setContentAreaFilled(false);
        LT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LTMouseExited(evt);
            }
        });
        LT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LTActionPerformed(evt);
            }
        });
        jPanel1.add(LT, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 542, 140, 30));

        dcn.setText("Develpor Contacts");
        dcn.setContentAreaFilled(false);
        dcn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dcnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dcnMouseExited(evt);
            }
        });
        dcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dcnActionPerformed(evt);
            }
        });
        jPanel1.add(dcn, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, 130, 36));

        abd.setText("About Develpors");
        abd.setContentAreaFilled(false);
        abd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                abdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                abdMouseExited(evt);
            }
        });
        abd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abdActionPerformed(evt);
            }
        });
        jPanel1.add(abd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, -1, 36));

        abs.setText("About Software");
        abs.setContentAreaFilled(false);
        abs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                absMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                absMouseExited(evt);
            }
        });
        abs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absActionPerformed(evt);
            }
        });
        jPanel1.add(abs, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 110, 36));

        guests.setText("Guests Record");
        guests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestsActionPerformed(evt);
            }
        });
        jPanel1.add(guests, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 147, 38));

        rooms.setText("Rooms Record");
        rooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsActionPerformed(evt);
            }
        });
        jPanel1.add(rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 380, 128, 36));

        jButton1.setText("Update Prices");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 430, 281, 36));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Administration Operations");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, -1, -1));

        logout.setText("Log out");
        logout.setEnabled(false);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 70, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 620));
        jLabel1.getAccessibleContext().setAccessibleParent(dcn);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdminRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminRegActionPerformed
        UserLogin ul=new UserLogin();
        ul.setVisible(true);
//        Close();
      
    }//GEN-LAST:event_AdminRegActionPerformed

    private void LTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LTActionPerformed
          ImageIcon icon = new ImageIcon("src/images/logout2.png");
    int input = JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Be Carefull...",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    login();
//                  logIn=false; 
//           login();
    }//GEN-LAST:event_LTActionPerformed

    private void guestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestsActionPerformed
            
        if(logIn==true){
            Reservation resv=new Reservation();
            resv.setVisible(true);
//            Close();   
        }else{
            JOptionPane.showMessageDialog(null,"Admin please Login First\nThanks");
        }
            
        // TODO add your handling code here:
    }//GEN-LAST:event_guestsActionPerformed

    private void roomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomsActionPerformed
    if(logIn==true){
            Rooms resv=new Rooms();
            resv.setVisible(true);
            Close();     
        }else{
            JOptionPane.showMessageDialog(null,"Admin please Login First \n Thanks");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_roomsActionPerformed

    private void abdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abdActionPerformed
AboutDevelpor a=new AboutDevelpor();
a.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_abdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 if(logIn==true){
            SetPrices spc=new SetPrices();
            spc.setVisible(true);
//            Close();     
        }else{
            JOptionPane.showMessageDialog(null,"Admin please Login First \n Thanks");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void absMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absMouseEntered
abs.setForeground(new java.awt.Color(0, 0, 255));        // TODO add your handling code here:
    }//GEN-LAST:event_absMouseEntered

    private void absMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_absMouseExited
abs.setForeground(new java.awt.Color(0, 0, 0));  // TODO add your handling code here:
    }//GEN-LAST:event_absMouseExited

    private void abdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abdMouseEntered
abd.setForeground(new java.awt.Color(0, 0, 255));         // TODO add your handling code here:
    }//GEN-LAST:event_abdMouseEntered

    private void abdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abdMouseExited
abd.setForeground(new java.awt.Color(0, 0, 0));         // TODO add your handling code here:
    }//GEN-LAST:event_abdMouseExited

    private void dcnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcnMouseEntered
dcn.setForeground(new java.awt.Color(0, 0, 255));         // TODO add your handling code here:
    }//GEN-LAST:event_dcnMouseEntered

    private void dcnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcnMouseExited
dcn.setForeground(new java.awt.Color(0, 0, 0));         // TODO add your handling code here:
    }//GEN-LAST:event_dcnMouseExited

    private void LTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LTMouseEntered

        Cursor cursor = new Cursor(Cursor.HAND_CURSOR) ;
        LT.setSize(160, 50);
        LT.setCursor(cursor);
         // TODO add your handling code here:
    }//GEN-LAST:event_LTMouseEntered

    private void LTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LTMouseExited
LT.setSize(140, 30);        // TODO add your handling code here:
    }//GEN-LAST:event_LTMouseExited

    private void absActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absActionPerformed
    AboutSoftware a=new AboutSoftware();
    a.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_absActionPerformed

    private void dcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dcnActionPerformed
DevloperContact a=new DevloperContact();
a.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_dcnActionPerformed

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
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        frmSplash splash = new frmSplash();
        splash.setVisible(true);
         try{
        for(int i = 0; i<=100; i++){
        Thread.sleep(i);
        
        if(i<30){
            splash.loadtxt.setText("loading files.....");
        }
        if(i>=30&&i<85){
            splash.loadtxt.setText("Initiating data...");
        }
        if(i>=85&&i<=100){
            splash.loadtxt.setText("Compeleted");
        }

        splash.progressbar.setValue(i);
        
       
       
        }
ControlPanel c=new ControlPanel();
c.Close();
        
        }catch(Exception e){
        
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                splash.setVisible(false);                
                new ControlPanel(false).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminReg;
    private javax.swing.JButton LT;
    private javax.swing.JButton abd;
    private javax.swing.JButton abs;
    private javax.swing.JCheckBox confirmLI;
    private javax.swing.JButton dcn;
    private javax.swing.JButton guests;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox logout;
    private javax.swing.JButton rooms;
    // End of variables declaration//GEN-END:variables
}
