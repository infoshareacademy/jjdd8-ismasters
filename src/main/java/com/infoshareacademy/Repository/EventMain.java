package com.infoshareacademy.Repository;


public class EventMain {
    private Place place;
    private String endDate;
    private String name;
    private String startDate;
    private Organizer organizer;

    public EventMain(Place place, String endDate, String name, String startDate, Organizer organizer) {
        this.place = place;
        this.endDate = endDate;
        this.name = name;
        this.startDate = startDate;
        this.organizer = organizer;
    }

    public EventMain(com.infoshareacademy.parser.Place place, String endDate, String name, String startDate, com.infoshareacademy.parser.Organizer organizer) {
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

    @Override
    public String toString() {
        return "EventMain{" +
                "place=" + place +
                ", endDate='" + endDate + '\'' +
                ", name='" + name + '\'' +
                ", startDate='" + startDate + '\'' +
                ", organizer=" + organizer +
                '}';
    }
}
