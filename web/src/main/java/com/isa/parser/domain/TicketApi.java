package com.isa.parser.domain;

import javax.json.bind.annotation.JsonbProperty;

public class TicketApi {

    @JsonbProperty("type")
    private String type;

    @JsonbProperty("startTicket")
    private String startCost;

    @JsonbProperty("endTicket")
    private String endCost;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartCost() {
        return startCost;
    }

    public void setStartCost(String startCost) {
        this.startCost = startCost;
    }

    public String getEndCost() {
        return endCost;
    }

    public void setEndCost(String endCost) {
        this.endCost = endCost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "type='" + type + '\'' +
                ", startCost='" + startCost + '\'' +
                ", endCost='" + endCost + '\'' +
                '}';
    }
}
