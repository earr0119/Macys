package thestoreapp;

import connection.ConnectionDB;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Orders {

    private int orderId;
    private String orderLineItem;
    private String billToName;
    private String billToAddress1;
    private String billToAddress2;
    private String orderCreateDttm;
    private String billToStore;
    private String orderStatus;

    public Orders() {
    }

    public Orders(int orderId, String orderLineItem, String billToName, String billToAddress1, String billToAddress2, String orderCreateDttm, String billToStore, String orderStatus) {
        this.orderId = orderId;
        this.orderLineItem = orderLineItem;
        this.billToName = billToName;
        this.billToAddress1 = billToAddress1;
        this.billToAddress2 = billToAddress2;
        this.orderCreateDttm = orderCreateDttm;
        this.billToStore = billToStore;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderLineItem() {
        return orderLineItem;
    }

    public void setOrderLineItem(String orderLineItem) {
        this.orderLineItem = orderLineItem;
    }

    public String getBillToName() {
        return billToName;
    }

    public void setBillToName(String billToName) {
        this.billToName = billToName;
    }

    public String getBillToAddress1() {
        return billToAddress1;
    }

    public void setBillToAddress1(String billToAddress1) {
        this.billToAddress1 = billToAddress1;
    }

    public String getBillToAddress2() {
        return billToAddress2;
    }

    public void setBillToAddress2(String billToAddress2) {
        this.billToAddress2 = billToAddress2;
    }

    public String getOrderCreateDttm() {
        return orderCreateDttm;
    }

    public void setOrderCreateDttm(String orderCreateDttm) {
        this.orderCreateDttm = orderCreateDttm;
    }

    public String getBillToStore() {
        return billToStore;
    }

    public void setBillToStore(String billToStore) {
        this.billToStore = billToStore;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void CreateOrder() {
        try {
            ConnectionDB connection = new ConnectionDB();
            Connection con = connection.conecctionOn();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO orders "
                    + "(orderid, orderlineitem, billtoname, billtoaddress1, billtoaddress2, ordercreatedttm, billtostore, orderstatus) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, orderId);
            stmt.setString(2, orderLineItem);
            stmt.setString(3, billToName);
            stmt.setString(4, billToAddress1);
            stmt.setString(5, billToAddress2);
            stmt.setString(6, orderCreateDttm);
            stmt.setString(7, billToStore);
            stmt.setString(8, orderStatus);
            stmt.executeUpdate();

            System.out.println("Order Created Successfully");

        } catch (SQLException ex) {
            System.out.println("");
        }
    }

    public void ShowOrders() {

        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        String query = "SELECT * FROM orders";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next() == false) {
                System.out.println("Order is not Found");
            } else {
                do {
                    System.out.println(rs.getInt("orderId") + " "
                            + rs.getString("orderLineItem") + " \t"
                            + rs.getString("billToName") + " \t"
                            + rs.getString("billToAddress1") + " \t"
                            + rs.getString("billToAddress2") + " \t"
                            + rs.getString("orderCreateDttm") + " \t"
                            + rs.getString("billToStore") + " \t"
                            + rs.getString("orderStatus"));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            System.out.println("Error");
            System.out.println(ex.getMessage());
        }

    }

}
