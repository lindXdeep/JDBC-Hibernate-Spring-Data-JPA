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
       
    }
}