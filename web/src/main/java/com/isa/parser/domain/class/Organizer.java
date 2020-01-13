package com.isa.parser.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organizer {

    @JsonProperty("id")
    private int id;

    @JsonProperty("designation")
    private String designation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }
}
