package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "organizer")
public class Organizer {

    @Column(name = "api_id")
    private int apiId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "designation")
    private String designation;

    @OneToMany (mappedBy = "organizer")
    private List<Event> event;

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

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

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    public Organizer(int apiId) {
        this.apiId = apiId;
    }
}
