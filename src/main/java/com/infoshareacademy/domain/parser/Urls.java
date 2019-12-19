package com.infoshareacademy.domain.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Urls {
    private String www;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String fb;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String tickets;

    public Urls() {
    }

    public Urls(String www, String fb, String tickets) {
        this.www = www;
        this.fb = fb;
        this.tickets = tickets;
    }

    public String getTickets() {
        return tickets;
    }

    public void setTickets(String tickets) {
        this.tickets = tickets;
    }

    public String getWww() {
        return www;
    }

    public void setWww(String www) {
        this.www = www;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    @Override
    public String toString() {
        return www;
    }
}
