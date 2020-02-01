package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.dto.*;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/single")
public class SingleEvent extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idParam = req.getParameter("id");
        PrintWriter writer = resp.getWriter();

        if (idParam == null || idParam.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Long id = Long.parseLong(idParam);


        EventDto eventDto = eventService.findById(id);
        OrganizerDto organizerDto = eventDto.getOrganizer();
        PlaceDto placeDto = eventDto.getPlace();
        AddressDto addressDto = placeDto.getAddressDto();
        UrlDto urlDto = eventDto.getUrls();

        logger.info("Long description: {}", eventDto.getDescLong());
        logger.info("Short description: {}", eventDto.getDescShort());
        Template template = templateProvider.getTemplate(getServletContext(), "single.ftlh");
        Map<String, Object> model = new HashMap<>();

        String dateOfEvent = eventDto.getStartDate().toString().substring(0, 10).concat(", godz: ").concat(eventDto.getStartDate().toString().substring(11));
        logger.info("dateOfEvent {}", dateOfEvent);

        model.put("date", dateOfEvent);
        model.put("eventDto", eventDto);
        model.put("organizerDto", organizerDto);
        model.put("placeDto", placeDto);
        model.put("urlDto", urlDto);
        model.put("addressDto", addressDto);

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

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
