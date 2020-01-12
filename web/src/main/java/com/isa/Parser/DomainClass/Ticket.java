package com.isa.Parser.DomainClass;

import javax.json.bind.annotation.JsonbProperty;

public class Ticket {

    @JsonbProperty("type")
    private String type;

    @JsonbProperty("startTicket")
    private String startCost;

    @JsonbProperty("endTicket")
    private String endCost;

    public Ticket(String type, String startCost, String endCost) {
        this.type = type;
        this.startCost = startCost;
        this.endCost = endCost;
    }

    public Ticket() {
    }

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
