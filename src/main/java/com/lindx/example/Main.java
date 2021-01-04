package com.lindx.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.lindx.example.util.Util;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Main {

    static Connection connection = null;
    static Statement statement = null;
    public static void main(String[] args) {
        
        connection = Util.getConnect();

        try {
            statement = connection.createStatement();

            statement.execute("SET FOREIGN_KEY_CHECKS=0");
            statement.execute("INSERT INTO cars(mark_id, model, price) VALUES (3, 'Kalina', 20000)");
            
            int res = statement.executeUpdate("UPDATE clients SET age = age + 1 WHERE name = 'petro'");
            System.out.println(res);

            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (3, 'Priora', 4000)");
            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (2, 'cayman', 14000)");
            statement.addBatch("INSERT INTO cars(mark_id, model, price) VALUES (1, 'S7', 100000)");

            statement.executeBatch();

            boolean closed = statement.isClosed();
            System.out.println(closed);
  
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testString() {

        String str ="Junit, Hello world!";
        assertEquals("Junit, Hello world!", str);

    }
}