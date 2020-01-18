package com.isa.domain.entity;

import javax.persistence.*;

@NamedQueries(
        {
                @NamedQuery (name = "Url.findAll", query = "SELECT u FROM Url u"),
                @NamedQuery(name = "Url.findByWww", query = "SELECT u FROM Url u WHERE u.wwwUrl = :www")
        }
)

@Entity
@Table (name = "url")
public class Url {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    @Column (name = "www_url")
    private String wwwUrl;

    @Column (name = "fb_url")
    private String fbUrl;

    @Column (name = "ticket_url")
    private String tickerUrl;

    @OneToOne (fetch = FetchType.LAZY, mappedBy = "url")
    private Event event;

    public Url() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWwwUrl() {
        return wwwUrl;
    }

    public void setWwwUrl(String wwwUrl) {
        this.wwwUrl = wwwUrl;
    }

    public String getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(String fbUrl) {
        this.fbUrl = fbUrl;
    }

    public String getTickerUrl() {
        return tickerUrl;
    }

    public void setTickerUrl(String tickerUrl) {
        this.tickerUrl = tickerUrl;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
