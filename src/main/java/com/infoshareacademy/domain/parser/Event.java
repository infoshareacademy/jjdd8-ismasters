package com.infoshareacademy.domain.parser;

import java.util.ArrayList;
import java.util.List;

public class Event {

    private int id;
    private Place place;
    private String endDate;
    private String name;
    private Urls urls;
    private List<Attachments> attachments = new ArrayList<>();
    private String descLong;
    private int categoryId;
    private String startDate;
    private Organizer organizer;
    private int active;
    private String descShort;
    private Ticket tickets;


    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrl(Urls urls) {
        this.urls = urls;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public Ticket getTickets() {
        return tickets;
    }

    public void setTickets(Ticket tickets) {
        this.tickets = tickets;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }

    public String toString() {
        StringBuilder eventString = new StringBuilder();
        eventString.append("Event information");
        //eventString.append("ID " + getid());
        eventString.append("Place " + getPlace() +"\n");
        eventString.append("endDate " + getEndDate()+"\n");
        eventString.append("Name " + getName()+"\n");
        eventString.append("URL " + getUrls()+"\n");
        //eventString.append("Attachments " + getAttachments());
        eventString.append("DescLong " + getDescLong()+"\n");
        //eventString.append("Category ID " + getCategoryId());
        eventString.append("start Date " + getStartDate()+"\n");
        eventString.append("Organizer " + getOrganizer()+"\n");
        //eventString.append("Active " + getActive());
        //eventString.append("Desc Short " + getDescShort());
        //eventString.append("Tickets" + getTickets());
        return eventString.toString();
    }


}
