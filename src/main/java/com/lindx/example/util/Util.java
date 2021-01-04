package com.lindx.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static Connection connection = null;
    
    public static Connection getConnect() {
        
        String url = "jdbc:mysql://localhost:3306/testbase";
        String user = "lindx";
        String pass = "MySql12345!";
        String param = "?autoReconnect=true&useSSL=false";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        
        try {
            connection = DriverManager.getConnection(url+param, user, pass);
            System.out.println("Connection Succsesfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
