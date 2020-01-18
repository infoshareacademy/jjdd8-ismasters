package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceApi {

    @JsonProperty("id")
    private int api_Id;

    @JsonProperty("subname")
    private String description;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private AddressExternal addressApi;

    public int getApi_Id() {
        return api_Id;
    }

    public void setApi_Id(int api_Id) {
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

    public AddressExternal getAddressApi() {
        return addressApi;
    }

    public void setAddressApi(AddressExternal addressApi) {
        this.addressApi = addressApi;
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
