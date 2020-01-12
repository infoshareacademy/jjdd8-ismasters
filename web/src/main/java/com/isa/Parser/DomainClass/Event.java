package com.isa.Parser.DomainClass;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    @JsonProperty("id")
    private Long api_Id;

    @JsonProperty("place")
    private Place place;

    @JsonProperty("endDate")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime endDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("urls")
    private Weblink weblink;

    @JsonProperty("attachments")
    private List<Attachment> attachments;

    @JsonProperty("descLong")
    private String LongDescription;

    @JsonProperty("categoryId")
    private int categoryEventId;

    @JsonProperty("startDate")
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime startDate;

    @JsonProperty("organizer")
    private Organizer organizer;

    @JsonProperty("active")
    private Boolean activeEvent;

    @JsonProperty("descShort")
    private String shortDescription;

    @JsonProperty("tickets")
    private Ticket ticket;

    public Event() {
    }

    public Long getApi_Id() {
        return api_Id;
    }

    public void setApi_Id(Long api_Id) {
        this.api_Id = api_Id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
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

    public Weblink getWeblink() {
        return weblink;
    }

    public void setWeblink(Weblink weblink) {
        this.weblink = weblink;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
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

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
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
