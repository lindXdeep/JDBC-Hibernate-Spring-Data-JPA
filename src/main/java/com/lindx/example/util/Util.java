package com.lindx.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {

    private static Connection connection = null;

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "lindx";
        String pass = "MySql12345!";
        String param = "?autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url + param, user, pass);
            System.out.println("Connection Succsesfull");
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
