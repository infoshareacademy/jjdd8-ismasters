package com.isa.domain.entity;


import javax.persistence.*;
import javax.ws.rs.core.Context;
import javax.xml.namespace.QName;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = "Attachments.findAll", query = "SELECT a FROM Attachments a"),
}
)

@Entity
@Table(name="attachments")
public class Attachments {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "filename")
    private String fileName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Attachments() {
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
