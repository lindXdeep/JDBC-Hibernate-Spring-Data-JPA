package com.lindx.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.lindx.example.entity.Address;
import com.lindx.example.service.AddressService;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class Main {

    static Connection connection = null;
    static Statement statement = null;
    public static void main(String[] args) {
        
        Address address = new Address();
            address.setId(1L);
            address.setCountry("USA");
            address.setCity("California");
            address.setStreet("Stars");
            address.setPostCode("123-456-789");
        
        AddressService addressService = new AddressService();

       List<Address> addresses =  addressService.getAll();

       System.out.println(addresses);
       
    }
}