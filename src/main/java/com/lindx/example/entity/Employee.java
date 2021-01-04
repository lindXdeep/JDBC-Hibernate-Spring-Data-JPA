package com.lindx.example.entity;

import java.sql.Date;
import java.util.Objects;

public class Employee {
    private Long id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private Long addressID;

    public Employee() {
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", firstname='" + firstname + "'" +
            ", lastname='" + lastname + "'" +
            ", birthday='" + birthday + "'" +
            ", addressID='" + addressID + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if(o == this)
           return true;
        if(o ==null || this.getClass() != o.getClass())
           return false;
    
        Employee employee = (Employee) o;
    
        return Objects.equals(id, employee.id) && 
                Objects.equals(firstname, employee.firstname) && 
                Objects.equals(lastname, employee.lastname) && 
                Objects.equals(birthday, employee.birthday) && 
                Objects.equals(addressID, employee.addressID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, birthday, addressID);
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return String return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return Date return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return Long return the addressID
     */
    public Long getAddressID() {
        return addressID;
    }

    /**
     * @param addressID the addressID to set
     */
    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

}