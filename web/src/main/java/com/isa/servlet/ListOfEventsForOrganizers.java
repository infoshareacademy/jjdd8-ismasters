package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.service.PaginationService;
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

/**
 *
 */
@WebServlet("/list-events-organizer")
public class ListOfEventsForOrganizers extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private PaginationService paginationService;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws SecurityException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "event-list-organizer.ftlh");
        Map<String, Object> model = new HashMap<>();

        String pageNumber = req.getParameter("pageNumber");

        if (!pageNumber.matches("[0-9]+")){
            pageNumber = "0";
        }

        int idOrganizer = 1;
        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            idOrganizer = Integer.parseInt(req.getParameter("id")) ;
        }

        int pageNum = Integer.parseInt(pageNumber);
        int next = paginationService.add(pageNum);
        int previous = paginationService.reduce(pageNum);
        int lastPageView = paginationService.getLastPage();

        List<EventDto> eventDtoList = new ArrayList<>();
        logger.info("idOrganizer {}", idOrganizer);
        eventDtoList.addAll(eventService.findByOrganizersId(idOrganizer));

//        eventDtoList.addAll(eventService.getEventsForView(pageNum, 20));

        final String googleId = (String) req.getSession().getAttribute("googleId");
        final String googleEmail = (String) req.getSession().getAttribute("googleEmail");
        logger.info("Google email set to {}", googleEmail);
        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
            model.put("googleEmail", googleEmail);
        } else {
            model.put("logged", "no");
            model.put("loginUrl", userAuthenticationService.buildLoginUrl());
        }

        logger.info("The size of a arraylist " + eventDtoList.size());

        model.put("idOrganizer", idOrganizer);
        model.put("eventDtoList", eventDtoList);
        model.put("next", next);
        model.put("previous", previous);
        model.put("lastPageView", lastPageView);

        try {
            template.process(model, rep.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
