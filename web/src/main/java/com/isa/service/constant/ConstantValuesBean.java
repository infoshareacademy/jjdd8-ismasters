package com.isa.service.constant;

import javax.ejb.Stateless;

@Stateless
public class ConstantValuesBean {

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

}
