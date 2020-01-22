package com.isa.domain.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.json.bind.annotation.JsonbProperty;

public class TicketApi {

    @JsonbProperty("type")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String type;

    @JsonbProperty("startTicket")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String startTicket;

    @JsonbProperty("endTicket")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String endTicket;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "type='" + type + '\'' +
                ", startCost='" + startTicket + '\'' +
                ", endCost='" + endTicket + '\'' +
                '}';
    }
}
