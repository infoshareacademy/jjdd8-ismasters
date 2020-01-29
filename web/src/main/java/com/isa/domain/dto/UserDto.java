package com.isa.domain.dto;

import com.isa.domain.entity.UserType;

import java.util.List;

public class UserDto {

    private Long id;

    private String email;

    private String googleId;

    private UserType userType;

    private List<EventDto> eventDtoList;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<EventDto> getEventDtoList() {
        return eventDtoList;
    }

    public void setEventDtoList(List<EventDto> eventDtoList) {
        this.eventDtoList = eventDtoList;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
