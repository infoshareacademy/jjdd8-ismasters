package com.isa.domain.entity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),

        @NamedQuery(name = "Event.countAll", query = "SELECT COUNT (e) FROM Event e"),

        @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e JOIN e.organizer o WHERE e.startDate>: startDate AND e.endDate<:endDate AND e.name LIKE CONCAT('%', :param, '%') OR o.designation LIKE CONCAT('%', :param, '%')")
}
)

@Entity
@Table(name = "event")
@Transactional
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_id")
    private Long apiId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "desc_short")
    private String descShort;

    @Column(name = "name")
    private String name;

    @Column(name = "desc_long", columnDefinition = "TEXT")
    private String descLong;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "favoriteEvents")
    private List<User> eventFav;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Place place;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "url_id", unique = true)
    private Url url;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private List<Attachments> attachments;

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }

    public Event() {
    }

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
}
