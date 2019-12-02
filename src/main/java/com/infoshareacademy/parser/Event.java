package com.infoshareacademy.parser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Event {

    private int id;
    private Place place;
    private String endDate;
    private String name;
    private Urls urls;
    private int[] attachments;
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

    public int[] getAttachments() {
        return attachments;
    }

    public void setAttachments(int[] attachments) {
        this.attachments = attachments;
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

    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Event information");
        string.append("ID " + getid()+ "/n");
        string.append("Place " + getPlace()+ "/n");
        string.append("endDate " + getEndDate()+ "/n");
        string.append("Name " + getName()+ "/n");
        string.append("URL " + getUrls()+ "/n");
        string.append("Attachments " + getAttachments()+ "/n");
        string.append("DescLong " + getDescLong()+ "/n");
        string.append("Category ID " + getCategoryId()+ "/n");
        string.append("start Date " + getStartDate()+ "/n");
        string.append("Organizer " + getOrganizer()+ "/n");
        string.append("Active " + getActive()+ "/n");
        string.append("Desc Short " + getDescShort()+ "/n");
        string.append("Tickets" + getTickets()+ "/n");
        return string.toString();
    }


}
