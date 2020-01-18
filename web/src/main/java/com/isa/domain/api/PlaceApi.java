package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceApi {

    @JsonProperty("id")
    private int apiId;

    @JsonProperty("subname")
    private String description;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private AddressExternal addressApi;

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
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
                "apiId=" + apiId +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
