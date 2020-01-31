package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.service.domain.EventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/search-events")
public class EventSearchList extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws SecurityException, IOException {

        String searchParam = req.getParameter("eventsearch");
        logger.info("Search Param: {}", searchParam);
        //TODO walidacja

        Template template = templateProvider.getTemplate(getServletContext(), "search-list.ftlh");
        Map<String, Object> model = new HashMap<>();

        List<EventDto> eventDtoList = new ArrayList<>();

        eventDtoList.addAll(eventService.findByName(searchParam));

        logger.info("The size of a arraylist " + eventDtoList.size());

        model.put("eventDtoList", eventDtoList);

        try {
            template.process(model, rep.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }


}
