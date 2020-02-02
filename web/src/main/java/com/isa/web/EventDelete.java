package com.isa.web;

import com.isa.dao.EventDao;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/admin/delete/{id}")
public class EventDelete {

    @Inject
    EventDao eventDao;

    @DELETE
    public Response deleteComputer(@PathParam("id") Long id) {

        if (eventDao.findById(id) != null) {
            eventDao.delete(id);
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }
    }
}
