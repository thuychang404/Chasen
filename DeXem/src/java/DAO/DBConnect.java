package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    protected static Connection connectDB;

    public static Connection DBConnect() {
        try {
            String user = "root";
            String pass = "123456";
            String databaseName = "iot";
            String url = "jdbc:mysql://localhost:3306/" + databaseName;
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public static void main(String[] args) {
//        connectDB = DBConnect();
//        if (connectDB != null) {
//            System.out.println("Ket noi Thanh Cong!");
//        } else {
//            System.out.println("1. Xem lai code.\n" +
//                    "2. Kiem tra add libraries (Download MySQL JDBC driver JAR file).\n" );
//        }
//    }

}
