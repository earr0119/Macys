package connection;

import java.util.logging.Level;
import java.util.logging.Logger;
import mainthestoreapp.StoreApp;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionDB {

    Connection con;
    
    public ConnectionDB(){
    }
    
    public Connection conecctionOn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/thestore", "root", "");
             System.out.println("");
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StoreApp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            System.out.println("Bad Connection");
        }
        return con;
    }
}
