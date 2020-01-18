package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AddressExternal {

    @JsonProperty("street")
    private String street;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
