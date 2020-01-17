package com.isa.service.constant;

import com.isa.service.ApiInitialization;

import javax.ejb.Stateless;

@Stateless
public class ConstantValuesBean {

    private final String eventsFile = ApiInitialization.class.getClassLoader().getResource("/events.json").getPath();
    private final String organizersFile = ApiInitialization.class.getClassLoader().getResource("/organizers.json").getPath();
    private final String placeFile = ApiInitialization.class.getClassLoader().getResource("/places.json").getPath();

    private final String eventsApi = "http://isa-proxy.blueazurit.com/gdansk-events/events.json";
    private final String organizersApi = "http://isa-proxy.blueazurit.com/gdansk-events/organizers.json";
    private final String placeApi = "http://isa-proxy.blueazurit.com/gdansk-events/places.json";


    public String getEventsApi() {
        return eventsApi;
    }

    public String getOrganizersApi() {
        return organizersApi;
    }

    public String getPlaceApi() {
        return placeApi;
    }

    public String getEventsFile() {
        return eventsFile;
    }

    public String getOrganizersFile() {
        return organizersFile;
    }

    public String getPlaceFile() {
        return placeFile;
    }



}
