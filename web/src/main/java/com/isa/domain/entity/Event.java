package com.isa.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "event")
public class Event {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "apiId")
    private Long apiId;

    @Column (name = "start_date")
    private LocalDateTime startDate;

    @Column (name = "end_date")
    private LocalDateTime endDate;

    @Column (name = "desc_short")
    private String descShort;

    @Column (name = "name")
    private String name;

    @Column (name = "desc_long")
    private String descLong;

    @Column (name = "category_id")
    private int categoryId;

    @Column (name = "active")
    private boolean active;

    @ManyToMany (mappedBy = "favoriteEvents")
    @JoinTable (name = "user_favorite_event")
    private List<User> eventFav;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ticket_type_id")
    private TicketType ticketType;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "organizer_id")
    private Organizer organizer;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "place_id", unique = true)
    private Place place;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "url_id", unique = true)
    private Url url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getEventFav() {
        return eventFav;
    }

    public void setEventFav(List<User> eventFav) {
        this.eventFav = eventFav;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public Event(Long apiId) {
        this.apiId = apiId;
    }
}