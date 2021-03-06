package com.lindx.example.entity;

import java.util.Objects;

public class Address {
    private Long id;
    private String country;
    private String city;
    private String street;
    private String postCode;

    @Override
    public boolean equals(Object o) {
        if(o == this)
            return true;
        if(o ==null || this.getClass() != o.getClass())
            return false;
        
        Address address = (Address) o;

        return Objects.equals(id, address.id) && 
               Objects.equals(country, address.country) && 
               Objects.equals(city, address.city) && 
               Objects.equals(street, address.street) && 
               Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, postCode);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", country='" + getCountry() + "'" +
            ", city='" + getCity() + "'" +
            ", street='" + getStreet() + "'" +
            ", postCode='" + getPostCode() + "'" +
            "}";
    }

    public Address() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
