package com.infoshareacademy.domain.parser;

public class Urls {
    private String www;
    private String fb;
    private String tickets;

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
        return "Urls:" +
                "www='" + www + '\'';
    }
}
