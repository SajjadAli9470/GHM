/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuestHouse;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Abid Ali
 */
public class Reservation extends javax.swing.JFrame {
    ConnectDatabase con_obj=new ConnectDatabase();
   Connection con;
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet res;
   DefaultTableModel d;
   String filename=null;
   byte[] photo=null;
   String vr,sr,sb,db;
    /**
     * Creates new form Reservation
     */
   
  
    public Reservation() {
        con=con_obj.EstablishCon();
        initComponents();
        con_obj.EstablishCon();
        autoID();
        RoomTypeL();
        Load_res();
        RoomnoL(); 
        bedTypeL();
  
        chkindate.setDate(new Date());
        chkoutdate.setDate(new Date());
        

    }
   
    public void amount(){
          int total=0;
        try {
            pstmt=con.prepareStatement("select * from Price where ID='"+1+"'");
            res=pstmt.executeQuery();
            while(res.next()){
                vr=res.getString(1);
                sr=res.getString(2);
                sb=res.getString(3);
                db=res.getString(4);
            }
              int  vip=Integer.parseInt(vr);
              int  std=Integer.parseInt(sr);
              int  sin=Integer.parseInt(sb);
              int  dob=Integer.parseInt(db);
           
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            String startdate=df1.format(chkindate.getDate());
            String enddate=df1.format(chkoutdate.getDate());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate f=LocalDate.parse(startdate,formatter);
            LocalDate e=LocalDate.parse(enddate,formatter);
            long x=ChronoUnit.DAYS.between(f, e);
            
       
         Object a= rtypecmb.getSelectedItem();
         Object b= btypecmb.getSelectedItem();
         if(a.equals("Standard"))
         {      total+=std;
             
             
         } 
         if(a.equals("VIP"))
         {   total+=vip;
            
            
         } 
         if(b.equals("single"))
         {total+=sin;
           
         } 
         if(b.equals("double"))
         {  total+=dob;
            
           
         } 
         total=(int) (x*total);
         String Total=String.valueOf(total);
         if(total>0){
             amounttxt.setText(Total+" Rupees");
         }else{
          
             JOptionPane.showMessageDialog(this,"Invalid checkout date....");
         }
         
//            System.out.println(total);
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
   
     private boolean isAnyRequiredFieldEmpty() {
        return nametxt.getText().equals("") || addtxt.getText().equals("") || mobiletxt.getText().equals("") || chkoutdate.getDate().equals(null);
    }
    public void close(){
        WindowEvent WCE=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(WCE);
        
    }
     public void autoID(){
        String id=null;
        String query = "select max(reid) from Reservation";
    try (Statement stmt = con.createStatement()) {
      ResultSet rs = stmt.executeQuery(query);
        System.out.println("here.......");
      while (rs.next()) {
        id = rs.getString(1);
      }
      if(id==null){
          reservetxt.setText("RE001");
      }
      else{
          long ID=Long.parseLong(id.substring(2,id.length()));
          ID++;
          reservetxt.setText("RE"+String.format("%03d",ID));
      }
    } catch (SQLException e) {
        System.out.println(e);
    }
  }
    public void Load_res(){
    int c;
       try {
           pstmt=con.prepareStatement("select * from Reservation ");
           res=pstmt.executeQuery();
           ResultSetMetaData rsd = res.getMetaData();
           c=rsd.getColumnCount();
           d=(DefaultTableModel)ResTable.getModel();
           d.setRowCount(0);
           while(res.next()){
               Vector v2=new Vector(); 
               for(int i=1;i<=c;i++){
                   v2.add(res.getString("reid"));
                   v2.add(res.getString("name"));
                   v2.add(res.getDate("checkin"));
                   v2.add(res.getDate("checkout"));
                    v2.add(res.getString("rtype"));
                     v2.add(res.getString("rno"));
                      v2.add(res.getString("btype"));
                      v2.add(res.getString("amount"));
               }
               d.addRow(v2);
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
       }
    
   }
     public void RoomTypeL(){
        try {
            pstmt=con.prepareStatement("SELECT DISTINCT rtype FROM Room");
            res=pstmt.executeQuery();
            rtypecmb.removeAllItems();
            while(res.next()){
                rtypecmb.addItem(res.getString("rtype"));
            }
        } catch (Exception ex) {

            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
     public void RoomnoL(){
        try {
            pstmt=con.prepareStatement("SELECT DISTINCT rid FROM Room");
            res=pstmt.executeQuery();
            rnocmb.removeAllItems();
            while(res.next()){
                rnocmb.addItem(res.getString("rid"));
            }
        } catch (Exception ex) {

            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
     public void bedTypeL(){
        try {
            pstmt=con.prepareStatement("SELECT DISTINCT btype FROM Room");
            res=pstmt.executeQuery();
            btypecmb.removeAllItems();
            while(res.next()){
                btypecmb.addItem(res.getString("btype"));
            }
        } catch (Exception ex) {

            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
     public void TableClick(){
          d=(DefaultTableModel)ResTable.getModel();
        int selectIndex =ResTable.getSelectedRow();
        String id=d.getValueAt(selectIndex, 0).toString();
        String address=null;
        String phone=null;
        
        Date strt=null,end=null;
        
        String remain="select * from Reservation where reid='"+id+"'";
         try {
            pstmt = con.prepareStatement(remain);
            res = pstmt.executeQuery();
            if (res.next()) {
                address=res.getString("address");
                phone=res.getString("mobile");
                
                strt=res.getDate("checkin");
                end=res.getDate("checkout");
           
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
      
        }

        reservetxt.setText(d.getValueAt(selectIndex, 0).toString());
        nametxt.setText(d.getValueAt(selectIndex, 1).toString());       
        addtxt.setText(address);
        mobiletxt.setText(phone);
        chkindate.setDate(strt);

        chkoutdate.setDate(end);
        rtypecmb.setSelectedItem(d.getValueAt(selectIndex, 4).toString());
        rnocmb.setSelectedItem(d.getValueAt(selectIndex, 5).toString());
        btypecmb.setSelectedItem(d.getValueAt(selectIndex, 6).toString());
        amounttxt.setText(d.getValueAt(selectIndex, 7).toString());
        
        

        savebutton.setEnabled(false);
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        savebutton = new javax.swing.JButton();
        editbutton = new javax.swing.JButton();
        deletebutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        reservelabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        mobiletxt = new javax.swing.JTextField();
        reservetxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chkindate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chkoutdate = new com.toedter.calendar.JDateChooser();
        rtypecmb = new javax.swing.JComboBox<>();
        rnocmb = new javax.swing.JComboBox<>();
        btypecmb = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        addtxt = new javax.swing.JTextArea();
        amounttxt = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        savebutton.setText("Save");
        savebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(savebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 80, 30));

        editbutton.setText("update");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(editbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 80, 30));

        deletebutton.setText("Delete");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        jPanel1.add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 90, 30));

        clearbutton.setText("Clear");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, 90, 30));
        jPanel1.add(reservelabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 42, 26, 22));

        ResTable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ResTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RID", "Name", "CheckIn", "CheckOut", "RoomType", "RoomNo", "BedType", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ResTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ResTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 630, 357));

        jButton1.setText("Quit");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 80, 30));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 102, 153), new java.awt.Color(102, 102, 255), new java.awt.Color(102, 102, 0), java.awt.Color.black));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 48, 63, -1));

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });
        jPanel3.add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 45, 139, -1));

        jLabel4.setText(" Address");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 79, 30));

        jLabel5.setText("Mobile");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 167, 58, -1));

        mobiletxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobiletxtActionPerformed(evt);
            }
        });
        jPanel3.add(mobiletxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 164, 139, -1));

        reservetxt.setEditable(false);
        reservetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservetxtActionPerformed(evt);
            }
        });
        jPanel3.add(reservetxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 14, 139, -1));

        jLabel2.setText("Booking#:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 17, -1, -1));

        jLabel6.setText("Check in");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 60, 23));
        jPanel3.add(chkindate, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 202, 139, -1));

        jLabel7.setText("Check out");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 241, 77, -1));

        jLabel8.setText("Room Type");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 282, -1, -1));

        jLabel9.setText("Room  no");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 320, -1, -1));

        jLabel10.setText("Bed Type");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 358, -1, -1));

        chkoutdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                chkoutdateMouseEntered(evt);
            }
        });
        jPanel3.add(chkoutdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 241, 139, -1));

        rtypecmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(rtypecmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 279, 139, -1));

        rnocmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(rnocmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 317, 139, -1));

        btypecmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        btypecmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btypecmbActionPerformed(evt);
            }
        });
        jPanel3.add(btypecmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 355, 139, -1));

        addtxt.setColumns(20);
        addtxt.setLineWrap(true);
        addtxt.setRows(5);
        addtxt.setWrapStyleWord(true);
        jScrollPane2.setViewportView(addtxt);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 88, 139, 63));

        amounttxt.setEditable(false);
        amounttxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amounttxtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                amounttxtMouseExited(evt);
            }
        });
        amounttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amounttxtActionPerformed(evt);
            }
        });
        jPanel3.add(amounttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 390, 160, 30));

        jButton2.setText("Amount");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 29, 240, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 37, -1, 501));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reservetxtActionPerformed

    private void mobiletxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobiletxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobiletxtActionPerformed

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ControlPanel cp=new ControlPanel(true);
        cp.setVisible(true);
        close();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ResTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResTableMouseClicked
       TableClick();
 
    }//GEN-LAST:event_ResTableMouseClicked

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed

        reservetxt.setText("");
        nametxt.setText("");
        addtxt.setText("");
        mobiletxt.setText("");
        chkindate.setDate(new Date());
        chkoutdate.setDate(null);
        rnocmb.setSelectedIndex(0);
        rtypecmb.setSelectedIndex(0);
        btypecmb.setSelectedIndex(0);
        amounttxt.setText("");
        savebutton.setEnabled(true);
        Load_res();
        autoID();
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        try {
            String reserveID=reservetxt.getText();
            String sql="delete from Reservation where reid='"+reserveID+"' ";
            pstmt = con.prepareStatement(sql);

            int res=pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Reservation Deleted");

            reservetxt.setText("");
            nametxt.setText("");
            addtxt.setText("");
            mobiletxt.setText("");
             chkindate.setDate(new Date());
             chkoutdate.setDate(null);
            rnocmb.setSelectedIndex(0);
            rtypecmb.setSelectedIndex(0);
            btypecmb.setSelectedIndex(0);
            amounttxt.setText("");
            savebutton.setEnabled(true);
            Load_res();
            autoID();

        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        if (!isAnyRequiredFieldEmpty()) {
   
        try {
            String reid=reservetxt.getText();
            String name=nametxt.getText();
            String address=addtxt.getText();
            String mobile=mobiletxt.getText();

            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            String checkin=df1.format(chkindate.getDate());
            String checkout=df1.format(chkoutdate.getDate());
            
            String roomno=rnocmb.getSelectedItem().toString();
            String roomtype= rtypecmb.getSelectedItem().toString();
            String bedtype=btypecmb.getSelectedItem().toString();
            String amount=amounttxt.getText();
            String sql="update Reservation set name='"+name+"',address='"+address+"',mobile = '"+mobile+"',checkin = '"+checkin+"',checkout = '"+checkout+"',btype = '"+bedtype+"',rno = '"+roomno+"',rtype = '"+roomtype+"',amount = '"+amount+"' where reid = '"+reid+"'";
            pstmt = con.prepareStatement(sql);

            int res=pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Room Edited");
        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            JOptionPane.showMessageDialog(this, "Missing any text field");
        }
        reservetxt.setText("");
        nametxt.setText("");
        addtxt.setText("");
        mobiletxt.setText("");
         chkindate.setDate(new Date());
        chkoutdate.setDate(null);
        rnocmb.setSelectedIndex(0);
        rtypecmb.setSelectedIndex(0);
        btypecmb.setSelectedIndex(0);
        amounttxt.setText("");
        Load_res();
        autoID();
        savebutton.setEnabled(true);
    }//GEN-LAST:event_editbuttonActionPerformed

    private void savebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebuttonActionPerformed
    if(!isAnyRequiredFieldEmpty() ){
        try {
            String reid =reservetxt.getText();
            String name=nametxt.getText();
            String address=addtxt.getText();
            String mobile=mobiletxt.getText();

            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
            String startdate=df1.format(chkindate.getDate());
            String enddate=df1.format(chkoutdate.getDate());
            String exactDate=df1.format(new Date());

          long x=0,y=0;
            try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate f=LocalDate.parse(startdate,formatter);
            LocalDate e=LocalDate.parse(enddate,formatter);
            LocalDate g=LocalDate.parse(exactDate,formatter);
             x=ChronoUnit.DAYS.between(f, e);
             y=ChronoUnit.DAYS.between(g, f);
             }catch(DateTimeParseException ex){System.out.println(ex);}
           if(x<=0){
               JOptionPane.showMessageDialog(this, "Checkout date is Invalid");        
           }else{
               if(y<0){
                 JOptionPane.showMessageDialog(this, "CheckIn date is Invalid");
            }else{
                   
            String rtype=rtypecmb.getSelectedItem().toString();
            String rno=rnocmb.getSelectedItem().toString();
            String btype=btypecmb.getSelectedItem().toString();
            String amount=amounttxt.getText();
            
            String sql="insert into Reservation(reid,name,address,mobile,checkin,checkout,btype,rno,rtype,amount) values('"+reid+"','"+name+"','"+address+"','"+mobile+"','"+startdate+"','"+enddate+"','"+btype+"','"+rno+"','"+rtype+"','"+amount+"')";
            stmt = con.createStatement();
            int res=stmt.executeUpdate(sql);
        
            JOptionPane.showMessageDialog(this, "Reservation Compeleted.....");

            reservetxt.setText("");
            nametxt.setText("");
            addtxt.setText("");
            mobiletxt.setText("");
            rtypecmb.setSelectedIndex(0);
            rnocmb.setSelectedIndex(0);
            btypecmb.setSelectedIndex(0);
            amounttxt.setText("");
            Load_res();
            autoID();
   
               }
           }
            
           
            
           

        } catch (SQLException ex) {
            Logger.getLogger(Reservation.class.getName()).log(Level.SEVERE, null, ex);
        }}else{JOptionPane.showMessageDialog(this,"Missing any text field");}
    }//GEN-LAST:event_savebuttonActionPerformed

    private void btypecmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btypecmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btypecmbActionPerformed

    private void amounttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amounttxtActionPerformed
                // TODO add your handling code here:
    }//GEN-LAST:event_amounttxtActionPerformed

    private void chkoutdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkoutdateMouseEntered
            
    }//GEN-LAST:event_chkoutdateMouseEntered

    private void amounttxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amounttxtMouseClicked
              // TODO add your handling code here:
    }//GEN-LAST:event_amounttxtMouseClicked

    private void amounttxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amounttxtMouseExited
          // TODO add your handling code here:
    }//GEN-LAST:event_amounttxtMouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
          
                amount();

          // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

  
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
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Reservation().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ResTable;
    private javax.swing.JTextArea addtxt;
    private javax.swing.JTextField amounttxt;
    private javax.swing.JComboBox<String> btypecmb;
    private com.toedter.calendar.JDateChooser chkindate;
    private com.toedter.calendar.JDateChooser chkoutdate;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton deletebutton;
    private javax.swing.JButton editbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mobiletxt;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel reservelabel;
    private javax.swing.JTextField reservetxt;
    private javax.swing.JComboBox<String> rnocmb;
    private javax.swing.JComboBox<String> rtypecmb;
    private javax.swing.JButton savebutton;
    // End of variables declaration//GEN-END:variables
}
