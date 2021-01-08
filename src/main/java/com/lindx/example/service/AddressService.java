package com.lindx.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lindx.example.dao.AddressDAO;
import com.lindx.example.entity.Address;
import com.lindx.example.util.Util;

public class AddressService implements AddressDAO {

    private Connection connection = Util.getConnection();

    @Override
    public void add(Address address) {

        String sql = "INSERT INTO Address (id, country, city, street, post_code)" + 
                        "VALUES(?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Address address) {
       
        String sql = "UPDATE Address SET country=?, city=?, street=?, post_code=? WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());

            preparedStatement.setLong(5, address.getId());
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Address address) {
        
        String sql = "DELETE FROM Address WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            preparedStatement.setLong(1, address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address getByAddressId(Long id) {

        Address address = new Address();

        String sql = "SELECT id, country, city, street, post_code FROM Address WHERE id=?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                address.setId(resultSet.getLong("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPostCode(resultSet.getString("post_code"));
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public List<Address> getAll() {
        
        List<Address> addresses = new ArrayList<>();

        String sql = "SELECT id, country, city, street, post_code FROM Address;";

        try (Statement statement = connection.createStatement()) {
            
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPostCode(resultSet.getString("post_code"));

                addresses.add(address);
            } 

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addresses;
    }
}