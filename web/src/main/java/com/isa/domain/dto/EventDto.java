package com.isa.domain.dto;

import java.time.LocalDateTime;
import java.util.List;


public class EventDto {

    private Long id;

    private Long apiExternalId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String descShort;

    private String name;

    private String descLong;

    private int categoryId;

    private boolean active;

    private AttachmentDto attachmentDto;

    public AttachmentDto getAttachmentDto() {
        return attachmentDto;
    }

    public void setAttachmentDto(AttachmentDto attachmentDto) {
        this.attachmentDto = attachmentDto;
    }

    private List<UserDto> eventFav;

    private TicketTypeDto ticketType;

    private OrganizerDto organizer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiExternalId() {
        return apiExternalId;
    }

    public void setApiExternalId(Long apiExternalId) {
        this.apiExternalId = apiExternalId;
    }


    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<UserDto> getEventFav() {
        return eventFav;
    }

    public void setEventFav(List<UserDto> eventFav) {
        this.eventFav = eventFav;
    }

    public TicketTypeDto getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketTypeDto ticketType) {
        this.ticketType = ticketType;
    }

    public OrganizerDto getOrganizer() {
        return organizer;
    }

    public void setOrganizer(OrganizerDto organizer) {
        this.organizer = organizer;
    }

    public PlaceDto getPlace() {
        return place;
    }

    public void setPlace(PlaceDto place) {
        this.place = place;
    }

    public UrlDto getUrls() {
        return urls;
    }

    public void setUrls(UrlDto urls) {
        this.urls = urls;
    }

    private PlaceDto place;

    private UrlDto urls;

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}