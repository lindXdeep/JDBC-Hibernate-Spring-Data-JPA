package com.lindx.example.entity;
public class Address {
    private Long id;
    private String country;
    private String city;
    private String street;
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
