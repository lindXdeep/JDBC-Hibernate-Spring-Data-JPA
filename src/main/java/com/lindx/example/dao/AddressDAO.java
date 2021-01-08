package com.lindx.example.dao;

import java.util.List;

import com.lindx.example.entity.Address;

public interface AddressDAO {

    void add(Address address);
    void update(Address address);
    void remove(Address address);

    Address getByAddressId(Long id);
    
    List<Address> getAll();
}