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
        
        Address addressUSA = new Address();
            addressUSA.setId(1L);
            addressUSA.setCountry("USA");
            addressUSA.setCity("California");
            addressUSA.setStreet("Stars");
            addressUSA.setPostCode("123-456-789");

        Address addressRU = new Address();
            addressRU.setId(1L);
            addressRU.setCountry("Russia");
            addressRU.setCity("Spb");
            addressRU.setStreet("asdf");
            addressRU.setPostCode("321-456-789");
        
        AddressService addressService = new AddressService();

        addressService.add(addressUSA);

        addressService.getAll().stream().forEach(System.out::println);

        addressService.getByAddressId(addressUSA.getId()).toString().lines().forEach(System.out::println);

        addressService.update(addressRU);
        addressService.getByAddressId(addressRU.getId()).toString().lines().forEach(System.out::println);

        addressService.remove(addressRU);
    }
}