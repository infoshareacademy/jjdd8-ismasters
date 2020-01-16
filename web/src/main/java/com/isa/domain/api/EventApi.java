package com.isa.domain.api;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventApi {

    @JsonProperty("id")
    private Long api_Id;

    @JsonProperty("place")
    private PlaceApi placeApi;

    @JsonProperty("endDate")
   // @JsonFormat(pattern = "YYYY-MM-ddTHH:mm:ssZ")
    private String endDate;

    @JsonProperty("name")
    private String name;

    @JsonProperty("urls")
    private WeblinkApi weblinkApi;


    @JsonProperty("attachments")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<AttachmentApi> attachments;

    @JsonProperty("descLong")
    private String LongDescription;

    @JsonProperty("categoryId")
    private int categoryEventId;

    @JsonProperty("startDate")
   // @JsonFormat(pattern = "YYYY-MM-ddTHH:mm:ssZ")
    private String startDate;

    @JsonProperty("organizer")
    private OrganizerApi organizerApi;

    @JsonProperty("active")
    private Boolean activeEvent;

    @JsonProperty("descShort")
    private String shortDescription;

    @JsonProperty("tickets")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private TicketApi ticketApi;

    public Long getApi_Id() {
        return api_Id;
    }

    public void setApi_Id(Long api_Id) {
        this.api_Id = api_Id;
    }

    public PlaceApi getPlaceApi() {
        return placeApi;
    }

    public void setPlaceApi(PlaceApi placeApi) {
        this.placeApi = placeApi;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeblinkApi getWeblinkApi() {
        return weblinkApi;
    }

    public void setWeblinkApi(WeblinkApi weblinkApi) {
        this.weblinkApi = weblinkApi;
    }

    @JsonIgnore
    public List<AttachmentApi> getAttachments() {
        return attachments;
    }

    @JsonIgnore
    public void setAttachments(List<AttachmentApi> attachments) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public OrganizerApi getOrganizerApi() {
        return organizerApi;
    }

    public void setOrganizerApi(OrganizerApi organizerApi) {
        this.organizerApi = organizerApi;
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

    public TicketApi getTicketApi() {
        return ticketApi;
    }

    public void setTicketApi(TicketApi ticketApi) {
        this.ticketApi = ticketApi;
    }

    @Override
    public String toString() {
        return "Event{" +
                "api_Id=" + api_Id +
                ", place=" + placeApi +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", weblink=" + weblinkApi +
                ", attachments=" + attachments +
                ", LongDescription='" + LongDescription + '\'' +
                ", categoryEventId=" + categoryEventId +
                ", startDate=" + startDate +
                ", organizer=" + organizerApi +
                ", activeEvent=" + activeEvent +
                ", shortDescription='" + shortDescription + '\'' +
                ", ticket=" + ticketApi +
                '}';
    }
}
