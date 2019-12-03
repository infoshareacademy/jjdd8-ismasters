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

}
