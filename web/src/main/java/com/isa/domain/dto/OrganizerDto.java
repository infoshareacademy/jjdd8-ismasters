package com.isa.domain.dto;

import java.util.List;

public class OrganizerDto {

    private int idDb;

    private Long idExternal;

    private String designation;

    private List<EventDto> eventDtoList;

    public int getIdDb() {
        return idDb;
    }

    public void setIdDb(int idDb) {
        this.idDb = idDb;
    }

    public Long getIdExternal() {
        return idExternal;
    }

    public void setIdExternal(Long idExternal) {
        this.idExternal = idExternal;
    }

    public List<EventDto> getEventDtoList() {
        return eventDtoList;
    }

    public void setEventDtoList(List<EventDto> eventDtoList) {
        this.eventDtoList = eventDtoList;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "OrganizerDto{" +
                "idDb=" + idDb +
                ", idExternal=" + idExternal +
                ", designation='" + designation + '\'' +
                ", eventDtoList=" + eventDtoList +
                '}';
    }
}
