package com.infoshareacademy.parser;

public class Event {

    private int id;
    private Place place;
    private String endDate;
    private String name;
    private Urls urls;
    private Attachments[] attachments;
    private String descLong;
    private int categoryId;
    private String startDate;
    private Organizer organizer;
    private int active;
    private String descShort;
    private Ticket tickets;

    public Attachments[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments[] attachments) {
        this.attachments = attachments;
    }

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



    public String toString(){
        StringBuilder string = new StringBuilder();
        string.append("Event information");
        string.append("ID " + getid());
        string.append("Place " + getPlace());
        string.append("endDate " + getEndDate());
        string.append("Name " + getName());
        string.append("URL " + getUrls());
        string.append("Attachments " + getAttachments());
        string.append("DescLong " + getDescLong());
        string.append("Category ID " + getCategoryId());
        string.append("start Date " + getStartDate());
        string.append("Organizer " + getOrganizer());
        string.append("Active " + getActive());
        string.append("Desc Short " + getDescShort());
        string.append("Tickets" + getTickets());
        return string.toString();
    }


}
