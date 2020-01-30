package com.isa.domain.dto;

import java.util.List;

public class PlaceDto {

    private int id;

    private int idExternal;

    private String subname;

    private String name;

    private AddressDto addressDto;

    private List<EventDto> eventDtoList;

    public PlaceDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdExternal() {
        return idExternal;
    }

    public void setIdExternal(int idExternal) {
        this.idExternal = idExternal;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public List<EventDto> getEventDtoList() {
        return eventDtoList;
    }

    public void setEventDtoList(List<EventDto> eventDtoList) {
        this.eventDtoList = eventDtoList;
    }

    @Override
    public String toString() {
        return "PlaceDto{" +
                "id=" + id +
                ", idExternal=" + idExternal +
                ", subname='" + subname + '\'' +
                ", name='" + name + '\'' +
                ", addressDto=" + addressDto +
                ", eventDtoList=" + eventDtoList +
                '}';
    }
}
