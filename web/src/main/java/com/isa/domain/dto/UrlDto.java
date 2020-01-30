package com.isa.domain.dto;

public class UrlDto {

    private int id;

    private String website;

    private String fbLink;

    private String ticketLink;

    private EventDto eventDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFbLink() {
        return fbLink;
    }

    public void setFbLink(String fbLink) {
        this.fbLink = fbLink;
    }

    public String getTicketLink() {
        return ticketLink;
    }

    public void setTicketLink(String ticketLink) {
        this.ticketLink = ticketLink;
    }

    public EventDto getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDto eventDTO) {
        this.eventDTO = eventDTO;
    }

    @Override
    public String toString() {
        return "UrlDto{" +
                "id=" + id +
                ", website='" + website + '\'' +
                ", fbLink='" + fbLink + '\'' +
                ", ticketLink='" + ticketLink + '\'' +
                ", eventDTO=" + eventDTO +
                '}';
    }
}
