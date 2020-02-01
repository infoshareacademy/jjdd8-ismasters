package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
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
        int pageNum = Integer.parseInt(pageNumber);
        logger.info("Page number {}", pageNumber);

        int idOrganizer = 1;
        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            idOrganizer = Integer.parseInt(req.getParameter("id")) ;
            logger.info("idorganizer: {}", idOrganizer);
        }

        int next = paginationService.add(pageNum);
        int previous = paginationService.reduce(pageNum);
        int lastPageView = paginationService.getLastPage();

        List<EventDto> eventDtoList = new ArrayList<>();

        eventDtoList.addAll(eventService.findByOrganizersIdPaged(idOrganizer, pageNum, 20));

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

        logger.info("EVENT DTO LIST: {}", eventDtoList.size());

        model.put("idOrganizer", idOrganizer);
        model.put("eventDtoList", eventDtoList);
        model.put("next", next);
        model.put("previous", previous);
        model.put("lastPageView", lastPageView);
        model.put("numberOfEvents", eventDtoList.size());

        try {
            template.process(model, rep.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
