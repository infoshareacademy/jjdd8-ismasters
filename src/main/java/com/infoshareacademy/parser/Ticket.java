package com.infoshareacademy.parser;

public class Ticket {

    private String type;

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
                '}';
    }
}
