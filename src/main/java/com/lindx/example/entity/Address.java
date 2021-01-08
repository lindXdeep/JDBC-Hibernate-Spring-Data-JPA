package com.lindx.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entit
@Table(name = ADDRESS)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = COUNTRY)
    private String country;

    @Column(name = CITY)
    private String city;

    @Column(name = STREET)
    private String street;

    @Column(name = POSTCODE, length = 10)
    private String postcode;

    public Address() {
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + id + "'" +
            ", country='" + country + "'" +
            ", city='" + city + "'" +
            ", street='" + street + "'" +
            ", postcode='" + postcode + "'" +
            "}";
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

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
