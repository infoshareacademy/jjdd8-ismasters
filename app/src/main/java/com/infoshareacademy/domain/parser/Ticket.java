package com.infoshareacademy.domain.parser;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String type;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String startTicket;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String endTicket;

    public Ticket() {
    }

    public Ticket(String type, String startTicket, String endTicket) {
        this.type = type;
        this.startTicket = startTicket;
        this.endTicket = endTicket;
    }

    public String getStartTicket() {
        return startTicket;
    }

    public void setStartTicket(String startTicket) {
        this.startTicket = startTicket;
    }

    public String getEndTicket() {
        return endTicket;
    }

    public void setEndTicket(String endTicket) {
        this.endTicket = endTicket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "type='" + type + '\'' +
                ", startTicket='" + startTicket + '\'' +
                ", endTicket='" + endTicket + '\'' +
                '}';
    }
}
