package thestoreapp;

import connection.ConnectionDB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Item {

    private int itemId;
    private String itemName;
    private double itemWeight;
    private float itemValue;
    private int storeIdItem;

    public Item() {
    }

    public Item(int itemId, String itemName, double itemWeight, float itemValue, int storeIdItem) {
        this.itemId = itemId;
        this.itemWeight = itemWeight;
        this.itemName = itemName;
        this.itemValue = itemValue;
        this.storeIdItem = storeIdItem;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }

    public float getItemValue() {
        return itemValue;
    }

    public void setItemValue(float itemValue) {
        this.itemValue = itemValue;
    }

    public int getStoreIdItem() {
        return storeIdItem;
    }

    public void setStoreIdItem(int storeIdItem) {
        this.storeIdItem = storeIdItem;
    }

    public void CreateItem() {
        try {
            ConnectionDB connection = new ConnectionDB();
            Connection con = connection.conecctionOn();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO item (itemid, itemname, itemweight, itemvalue) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, itemId);
            stmt.setString(2, itemName);
            stmt.setDouble(3, itemWeight);
            stmt.setFloat(4, itemValue);
            //stmt.setInt(5, storeIdItem);
            stmt.executeUpdate();

            System.out.println("Item Created Successfully");
            System.out.println("ID " + itemId + " Name " + itemName + " Located in Database");

        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println("Item Number " + itemId + " Is Not Unique");
            System.out.println(ex.getMessage());
        }
    }

    public void ShowItems() {
        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        String query = "SELECT * FROM item";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next() == false) {
                System.out.println("Item is not Found");
            } else {
                do {
                    System.out.println(rs.getInt("itemId") + " "
                            + rs.getString("itemName") + " \t"
                            + rs.getString("itemWeight") + " \t"
                            + rs.getString("itemValue") + " \t"
                            + rs.getInt("storeIdItem"));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

    public void AddItemToStore(String itemnamE, int itemID, String storenamE, int storeID) {
        try {
            ConnectionDB connection = new ConnectionDB();
            Connection con = connection.conecctionOn();
            String query = "UPDATE item SET storeiditem = ? WHERE itemid = ? AND itemname = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, storeID);
            preparedStmt.setInt(2, itemID);
            preparedStmt.setString(3, itemnamE);           
            int i = preparedStmt.executeUpdate();
            System.out.println(i + " records updated");
            if (i >= 1){
                System.out.println("Item Added To Store Successfully");
            } else {
                System.out.println("Item No Added");            
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }
    }

}