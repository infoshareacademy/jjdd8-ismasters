package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.domain.dto.OrganizerDto;
import com.isa.domain.entity.Organizer;
import com.isa.domain.entity.UserType;
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

@WebServlet("/event-list-admin")
public class AdminListOfEvents extends HttpServlet {

    private final int MAX_EVENT_NUMBER = 20;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "event-list-admin.ftlh");
        Map<String, Object> model = new HashMap<>();

        String pageNumber = req.getParameter("pageNumber");

        int pageNum = Integer.parseInt(pageNumber);
        int next = paginationService.add(pageNum);
        int previous = paginationService.reduce(pageNum);

        int lastPageView = paginationService.getLastPage();


        List<EventDto> eventDtoList = new ArrayList<>();

        eventDtoList.addAll(eventService.getEventsForView(pageNum, MAX_EVENT_NUMBER));

        logger.info("The size of a arraylist " + eventDtoList.size());

        model.put("eventDtoList", eventDtoList);
        model.put("next", next);
        model.put("previous", previous);
        model.put("lastPageView", lastPageView);

        final String googleId = (String) req.getSession().getAttribute("googleId");
        final String googleEmail = (String) req.getSession().getAttribute("googleEmail");
        final UserType userType = (UserType) req.getSession().getAttribute("userType");
        logger.info("Google email set to {}", googleEmail);

        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
            model.put("googleEmail", googleEmail);
            model.put("userType", userType);
        } else {
            model.put("logged", "no");
            model.put("loginUrl", userAuthenticationService.buildLoginUrl());
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
