package com.lindx.service;

import java.sql.SQLException;
import java.util.List;

import com.lindx.example.dao.AddressDAO;
import com.lindx.example.entity.Address;
import com.lindx.example.util.SessionUtil;

import org.hibernate.query.Query;

public class AddressService implements AddressDAO {

    @Override
    public void add(Address address) throws SQLException {
        
        SessionUtil.openTransactionSession();
        
        SessionUtil.getSession().save(address);

        SessionUtil.closeTransactionSession();
    }

    @Override
    public List<Address> getAll() throws SQLException {
        
        String sql = "SELECT * FROM ADDRESS";

        SessionUtil.openTransactionSession();

        Query query = SessionUtil.getSession().createNativeQuery(sql).addEntity(Address.class);

        List<Address> addresses = query.list();

        SessionUtil.closeTransactionSession();

        return addresses;
    }

    @Override
    public Address getById(Long id) throws SQLException {
        
        String sql = "SELECT * FROM ADDRESS WHERE id = :id";

        SessionUtil.openTransactionSession();

        Query query = SessionUtil.getSession().createNativeQuery(sql).addEntity(Address.class);
            query.setParameter("id", id);

        Address address = (Address) query.getSingleResult();
 
        SessionUtil.closeTransactionSession();

        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        
        SessionUtil.openTransactionSession();

        SessionUtil.getSession().update(address);

        SessionUtil.closeTransactionSession();
    }

    @Override
    public void remove(Address address) throws SQLException {

        SessionUtil.openTransactionSession();

        SessionUtil.getSession().remove(address);

        SessionUtil.closeTransactionSession();
    }
}
