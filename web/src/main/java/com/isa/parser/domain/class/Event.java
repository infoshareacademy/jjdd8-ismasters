package com.isa.parser.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    @JsonProperty("id")
    private Long api_Id;

    @JsonProperty("place")
    private com.isa.parser.domain.Place place;

    @JsonProperty("endDate")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime endDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("urls")
    private com.isa.parser.domain.Weblink weblink;

    @JsonProperty("attachments")
    private List<com.isa.parser.domain.Attachment> attachments;

    @JsonProperty("descLong")
    private String LongDescription;

    @JsonProperty("categoryId")
    private int categoryEventId;

    @JsonProperty("startDate")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime startDate;

    @JsonProperty("organizer")
    private com.isa.parser.domain.Organizer organizer;

    @JsonProperty("active")
    private Boolean activeEvent;

    @JsonProperty("descShort")
    private String shortDescription;

    @JsonProperty("tickets")
    private com.isa.parser.domain.Ticket ticket;

    public Event() {
    }

    public Long getApi_Id() {
        return api_Id;
    }

    public void setApi_Id(Long api_Id) {
        this.api_Id = api_Id;
    }

    public com.isa.parser.domain.Place getPlace() {
        return place;
    }

    public void setPlace(com.isa.parser.domain.Place place) {
        this.place = place;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.isa.parser.domain.Weblink getWeblink() {
        return weblink;
    }

    public void setWeblink(com.isa.parser.domain.Weblink weblink) {
        this.weblink = weblink;
    }

    public List<com.isa.parser.domain.Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<com.isa.parser.domain.Attachment> attachments) {
        this.attachments = attachments;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String longDescription) {
        LongDescription = longDescription;
    }

    public int getCategoryEventId() {
        return categoryEventId;
    }

    public void setCategoryEventId(int categoryEventId) {
        this.categoryEventId = categoryEventId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public com.isa.parser.domain.Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(com.isa.parser.domain.Organizer organizer) {
        this.organizer = organizer;
    }

    public Boolean getActiveEvent() {
        return activeEvent;
    }

    public void setActiveEvent(Boolean activeEvent) {
        this.activeEvent = activeEvent;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public com.isa.parser.domain.Ticket getTicket() {
        return ticket;
    }

    public void setTicket(com.isa.parser.domain.Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Event{" +
                "api_Id=" + api_Id +
                ", place=" + place +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", weblink=" + weblink +
                ", attachments=" + attachments +
                ", LongDescription='" + LongDescription + '\'' +
                ", categoryEventId=" + categoryEventId +
                ", startDate=" + startDate +
                ", organizer=" + organizer +
                ", activeEvent=" + activeEvent +
                ", shortDescription='" + shortDescription + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
