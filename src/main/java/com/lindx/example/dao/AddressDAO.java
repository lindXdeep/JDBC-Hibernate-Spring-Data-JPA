package com.lindx.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.lindx.example.entity.Address;

public interface AddressDAO {
    void add(Address address) throws SQLException;
    List<Address> getAll() throws SQLException;
    Address getById(Long id) throws SQLException;
    void update(Address address) throws SQLException;
    void remove(Address address) throws SQLException;
}
