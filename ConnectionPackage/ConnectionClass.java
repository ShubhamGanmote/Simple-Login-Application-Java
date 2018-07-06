package ConnectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {
    
    public Connection con;
    
    public void getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?autoReconnect=true&useSSL=false", "root", "Wel-come17");
            
            System.out.println("Connection Successful.");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
