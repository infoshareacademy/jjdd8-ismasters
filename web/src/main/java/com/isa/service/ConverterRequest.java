package com.isa.service;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class ConverterRequest {

    public String buildClientRequest(String url) {

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(url);

        Response response = target.request().get();

        return response.readEntity(String.class);
    }
}
