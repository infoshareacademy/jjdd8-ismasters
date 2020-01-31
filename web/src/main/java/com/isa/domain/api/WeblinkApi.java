package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeblinkApi {

    @JsonProperty("www")
    private String website;

    @JsonProperty("tickets")
    private String tickets;

    @JsonProperty("fb")
    private String fb;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    @Override
    public String toString() {
        return "Weblinks{" +
                "website='" + website + '\'' +
                ", tickets='" + tickets + '\'' +
                ", fb='" + fb + '\'' +
                '}';
    }
}
