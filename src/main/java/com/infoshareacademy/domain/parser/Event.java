package com.infoshareacademy.domain.parser;

import com.infoshareacademy.menu.MenuBuilder;

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

    public Event(int id, Place place, String endDate, String name, Urls urls, List<Attachments> attachments, String descLong, int categoryId, String startDate, Organizer organizer, int active, String descShort, Ticket tickets) {
        this.id = id;
        this.place = place;
        this.endDate = endDate;
        this.name = name;
        this.urls = urls;
        this.attachments = attachments;
        this.descLong = descLong;
        this.categoryId = categoryId;
        this.startDate = startDate;
        this.organizer = organizer;
        this.active = active;
        this.descShort = descShort;
        this.tickets = tickets;
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

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = attachments;
    }

    public String extractDateOnly(String date) {
        return date.substring(0, 10); //extract only date form mixed data&time string
    }

    public String extractTimeOnly(String date) {
        return date.substring(11, 16); //extract only date form mixed data&time string
    }

    public String toString() {
        return "Nazwa wydarzenia:" + MenuBuilder.CYAN +   getName() + MenuBuilder.DEFAULT + "\n" +
                "Miejsce wydarzenia: " + getPlace() + "\n" +
                "Rozpoczęcie: " + extractDateOnly(getStartDate()) + ", godz: " + extractTimeOnly(getStartDate()) + "\n" +
                getOrganizer() + "\n" +
                "Adres WWW: " + getUrls() + "\n";
    }


}
