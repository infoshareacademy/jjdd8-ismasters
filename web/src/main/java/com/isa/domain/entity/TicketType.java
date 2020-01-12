package com.isa.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "ticket_type")
public class TicketType {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "ticket_type_name")
    private String ticketTypeName;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "ticketType")
    private List<TicketType> ticketType;

    public TicketType(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketTypeName() {
        return ticketTypeName;
    }

    public void setTicketTypeName(String ticketTypeName) {
        this.ticketTypeName = ticketTypeName;
    }

    public List<TicketType> getTicketType() {
        return ticketType;
    }

    public void setTicketType(List<TicketType> ticketType) {
        this.ticketType = ticketType;
    }
}
