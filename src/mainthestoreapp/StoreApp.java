package mainthestoreapp;

import connection.ConnectionDB;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import thestoreapp.Item;
import thestoreapp.Orders;
import thestoreapp.Stores;

public class StoreApp {

    public static void main(String[] args) throws InstantiationException {
        ConnectionDB connection = new ConnectionDB();
        Connection con = connection.conecctionOn();
        Scanner in = new Scanner(System.in);
        int subMenu = 0;
        Stores store = new Stores();
        Item item = new Item();
        Orders order = new Orders();

        while (subMenu != 13) {
            System.out.println("\n*******************************************");
            System.out.println("Welcome to The Store\n");
            System.out.println("Please, Select an Option "
                    + "\n1. Create a Store"
                    + "\n2. Show Stores"
                    + "\n3. Find Store By ID"
                    + "\n4. Find Store By Name "
                    + "\n5. Find Store By Id and By Name"
                    + "\n6. create item"
                    + "\n7. Show Items"
                    + "\n8. Add Item To Store"
                    + "\n9. Start a Order"
                    + "\n10.Show Orders"
                    + "\n11.Check Details"
                    + "\n12. Exit");
            System.out.println("*******************************************");
            subMenu = in.nextInt();

            switch (subMenu) {
                case 1:
                    System.out.println("What Is the Store ID?");
                    int storeId = in.nextInt();
                    System.out.println("What Is the Store Name?");
                    String storeName = in.next();
                    System.out.println("What Is the Store District?");
                    String storeDistrict = in.next();
                    System.out.println("What Is the Pilot Name Id?");
                    String pilotNameId = in.next();
                    store.setStoreId(storeId);
                    store.setStoreName(storeName);
                    store.setStoreDistrict(storeDistrict);
                    store.setPilotNameId(pilotNameId);
                    store.CreateStore();
                    break;

                case 2:
                    System.out.println("Check All Stores Registered in the System");
                    store.DisplayStore();
                    break;

                case 3:
                    System.out.println("What Is the Store ID?");
                    int idstore = in.nextInt();
                    store.DisplayStore(idstore);
                    break;

                case 4:
                    System.out.println("What Is the Store Name?");
                    String nameStore1 = in.next();
                    store.DisplayStore(nameStore1);
                    break;
                    
                case 5:
                    System.out.println("What Is the Store ID?");
                    int idstore1 = in.nextInt();
                    System.out.println("What Is the Store Name?");
                    String nameStore2 = in.next();
                    store.DisplayStore(idstore1, nameStore2);
                    break;

                case 6:
                    System.out.println("What Is the item ID?");
                    int itemId = in.nextInt();
                    System.out.println("What Is the item name?");
                    String itemName = in.next();
                    System.out.println("What Is the item weight?");
                    double itemWeight = in.nextDouble();
                    System.out.println("What Is the item value?");
                    float itemValue = in.nextFloat();

                    item.setItemId(itemId);
                    item.setItemName(itemName);
                    item.setItemWeight(itemWeight);
                    item.setItemValue(itemValue);

                    item.CreateItem();
                    break;

                case 7:
                    System.out.println("Check All Items Registered in the System");
                    item.ShowItems();
                    break;

                case 8:
                    System.out.println("What is Item Name");
                    String itemnamE = in.next();
                    System.out.println("What Item ID");
                    int itemID = in.nextInt();
                    System.out.println("What Store is going to sell this item");
                    String storenamE = in.next();
                    System.out.println("What is the Store ID");
                    int storeID = in.nextInt();
                    item.AddItemToStore(itemnamE, itemID, storenamE, storeID);
                    break;

                case 9:
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(System.currentTimeMillis());
                    String time = formatter.format(date);

                    System.out.println("Start a Order");

                    System.out.println("What is Order Id?");
                    int orderId = in.nextInt();

                    System.out.println("What is Order Line Item?");
                    String orderLineItem = in.next();

                    System.out.println("What is Bill To Name?");
                    String billToName = in.next();

                    System.out.println("What is Bill To Address1?");
                    String billToAddress1 = in.next();

                    System.out.println("What is Bill To Address2?");
                    String billToAddress2 = in.next();

                    System.out.println("What is Bill To Store?");
                    String billToStore = in.next();

                    System.out.println("What is Order Status?");
                    String orderStatus = in.next();

                    order.setOrderId(orderId);
                    order.setOrderLineItem(orderLineItem);
                    order.setBillToName(billToName);
                    order.setBillToAddress1(billToAddress1);
                    order.setBillToAddress2(billToAddress2);
                    order.setOrderCreateDttm(time);
                    order.setBillToStore(billToStore);
                    order.setOrderStatus(orderStatus);
                    order.CreateOrder();
                    break;

                case 10:
                    System.out.println("Check All Orders Registered in the System");
                    order.ShowOrders();
                    break;
                    
                case 11:
                    break;

                case 12:
                    System.out.println("Usted ha finalizado el programa");
                    break;
            }
        }
    }
}
