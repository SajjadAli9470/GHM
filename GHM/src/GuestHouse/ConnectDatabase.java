
package GuestHouse;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectDatabase {
    Connection con=null;
    public Connection EstablishCon(){
    try{
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        con=DriverManager.getConnection("jdbc:ucanaccess://src\\Record\\managment.accdb");
//        JOptionPane.showMessageDialog(null, "Connected");    
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
     }
    return con;
    }
}

