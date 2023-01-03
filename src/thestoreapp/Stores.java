package thestoreapp;

import connection.ConnectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;

public class Stores {

    private int storeId;
    private String storeName;
    private String storeDistrict;
    private String pilotNameId;

    public Stores() {
    }

    public Stores(int storeId, String storeName, String storeDistrict, String pilotNameId) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeDistrict = storeDistrict;
        this.pilotNameId = pilotNameId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreDistrict() {
        return storeDistrict;
    }

    public void setStoreDistrict(String storeDistrict) {
        this.storeDistrict = storeDistrict;
    }

    public String getPilotNameId() {
        return pilotNameId;
    }

    public void setPilotNameId(String pilotNameId) {
        this.pilotNameId = pilotNameId;
    }

    public void CreateStore() {

        try {
            ConnectionDB connection = new ConnectionDB();
            Connection con = connection.conecctionOn();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO store (storeid, storename, storedistrict, pilotnameid) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, storeId);
            stmt.setString(2, storeName);
            stmt.setString(3, storeDistrict);
            stmt.setString(4, pilotNameId);
            stmt.executeUpdate();

            System.out.println("Store Created Successfully");
            DisplayStore(storeId, storeName);
            System.out.println("");

        } catch (SQLException ex) {
            System.out.println("Store Number" + storeId + " Is Not Unique");
        }
    }

    public void DisplayStore() {

        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        String query = "SELECT * FROM store";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next() == false) {
                System.out.println("Store is not Found");
            } 
            else {
                do {
                    System.out.println(rs.getInt("storeId") + " "
                            + rs.getString("storeName") + " \t"
                            + rs.getString("storeDistrict") + " \t"
                            + rs.getString("pilotNameId"));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    public void DisplayStore(int idstore, String nameStore) {

        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        String query = "SELECT * FROM store WHERE storeid = " + idstore + " AND storename = '" + nameStore + "'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next() == false) {  
                  System.out.println("Store is not Found");
            }              
                do {
                System.out.println(rs.getInt("storeId") + " "
                        + rs.getString("storeName") + " \t"
                        + rs.getString("storeDistrict") + " \t"
                        + rs.getString("pilotNameId"));
                }while (rs.next());
            
        } catch (SQLException ex) {
            System.out.println("Store Name  and Store Number Not Found");
            System.out.println("Please, Type a Valid Store Id  and Store Name");
            System.out.println(ex.getMessage());
        }
    }

    public void DisplayStore(int idStore) {

        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        String query = "SELECT * FROM store WHERE storeid = " + idStore;

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next() == false) {
                System.out.println("storeid is not registred");
            } else {
                do {
                    System.out.println(rs.getInt("storeId") + " "
                            + rs.getString("storeName") + " \t"
                            + rs.getString("storeDistrict") + " \t"
                            + rs.getString("pilotNameId"));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    public void DisplayStore(String nameStore) {

        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        String query = "SELECT * FROM store WHERE storename = '" + nameStore + "'";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next() == false) {
                System.out.println("store name is not registred");
            }   
                do{
                System.out.println(rs.getInt("storeId") + " "
                        + rs.getString("storeName") + " \t"
                        + rs.getString("storeDistrict") + " \t"
                        + rs.getString("pilotNameId"));
                }while (rs.next());
        
        } catch (SQLException ex) {
            //Logger.getLogger(StoreApp.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }
}
