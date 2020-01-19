package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search/{id}")
public class SearchEvents extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String search = req.getParameter("search");

        if (search == null || search.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

//        EventDTO eventDTO = eventService.searchEvents(search);


    }
}