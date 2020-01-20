package com.isa.service.constant;

import javax.ejb.Stateless;

@Stateless
public class ConstantValuesBean {

    private final String eventsFile = "events.json";
    private final String organizersFile = "organizers.json";
    private final String placeFile = "places.json";

    private final String eventsApi = "http://isa-proxy.blueazurit.com/gdansk-events/events.json";
    private final String organizersApi = "http://isa-proxy.blueazurit.com/gdansk-events/organizers.json";
    private final String placeApi = "http://isa-proxy.blueazurit.com/gdansk-events/places.json";


    private boolean externalApiStatus = false;

    public boolean getExternalApiStatus() {
        return externalApiStatus;
    }

    public void setExternalApiStatus(boolean externalApiStatus) {
        this.externalApiStatus = externalApiStatus;
    }

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
