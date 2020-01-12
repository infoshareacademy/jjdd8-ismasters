package com.isa.Parser.DomainClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weblink {

    @JsonProperty("www")
    private String website;

    @JsonProperty("tickets")
    private String tickets;

    @JsonProperty("fb")
    private String fb;

    public Weblink() {
    }

    public Weblink(String website, String tickets, String fb) {
        this.website = website;
        this.tickets = tickets;
        this.fb = fb;
    }

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
