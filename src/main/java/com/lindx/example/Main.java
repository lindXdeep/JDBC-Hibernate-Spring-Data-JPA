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

        Address address2 = new Address();
            address.setId(1L);
            address.setCountry("Russia");
            address.setCity("Spb");
            address.setStreet("asdf");
            address.setPostCode("321-456-789");
        
        AddressService addressService = new AddressService();

        addressService.add(address);

        addressService.getAll().stream().forEach(System.out::println);

        addressService.getByAddressId(1L).toString().lines().forEach(System.out::println);

        addressService.update(address);

        addressService.getByAddressId(1L).toString().lines().forEach(System.out::println);
    }
}