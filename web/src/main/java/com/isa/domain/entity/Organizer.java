package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@NamedQueries (
        {
                @NamedQuery (name = "Organizer.findAll", query = "SELECT o FROM Organizer o"),
                @NamedQuery (name = "Organizer.findByApiId", query = "SELECT o FROM Organizer o WHERE o.apiId=:apiId")
        }
)


@Entity
@Table (name = "organizer")
public class Organizer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "api_id")
    private Long apiId;

    @Column (name = "designation")
    private String designation;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "organizer")
    private List<Event> event;

    public Organizer() {

    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
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

}
