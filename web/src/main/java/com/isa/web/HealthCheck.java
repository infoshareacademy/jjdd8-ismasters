package com.isa.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/health")
public class HealthCheck {
   @GET
   public int checkHealth() {
       return Response.Status.OK.getStatusCode();
   }

}
