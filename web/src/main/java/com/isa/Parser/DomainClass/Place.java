package com.isa.Parser.DomainClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {

    @JsonProperty("id")
    private Long api_Id;

    @JsonProperty("subname")
    private String description;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private Address address;

    public Place(Long api_Id, String description, String name) {
        this.api_Id = api_Id;
        this.description = description;
        this.name = name;
    }

    public Place() {
    }

    public Long getApi_Id() {
        return api_Id;
    }

    public void setApi_Id(Long api_Id) {
        this.api_Id = api_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Place{" +
                "api_Id=" + api_Id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
