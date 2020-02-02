package com.isa.servlet;


import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.dao.EventDao;
import com.isa.domain.dto.EventDto;
import com.isa.domain.entity.Event;
import com.isa.domain.entity.User;
import com.isa.domain.entity.UserType;
import com.isa.service.UserService;
import com.isa.service.domain.EventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;

@Transactional
@WebServlet("/favorite-events-list")
public class FavoriteEventsList extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private UserService userService;

    @Inject
    private EventDao eventDao;

    @Inject
    UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {



        Template template = templateProvider.getTemplate(getServletContext(), "user-fav-list.ftlh");
        Map<String, Object> model = new HashMap<>();
        List<EventDto> eventDtoList = new ArrayList<>();


        model.put("eventDtoList", eventDtoList);
        final String googleId = (String) req.getSession().getAttribute("googleId");
        final String googleEmail = (String) req.getSession().getAttribute("googleEmail");
        final UserType userType = (UserType) req.getSession().getAttribute("userType");

        Optional<User> user = userService.findByEmail(googleEmail);

        eventDtoList.addAll(eventService.getFavEvents(user.get().getId()));


        logger.debug("Google email set to {}", googleEmail);
        logger.info("Id usera {}", req.getSession().getAttribute("userId"));
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("Request POST method");
        String eventId = req.getParameter("id");

        final String googleEmail = (String) req.getSession().getAttribute("googleEmail");

        Optional<User> user = userService.findByEmail(googleEmail);
        Optional<Event> event = eventDao.findById(Long.parseLong(eventId));

        user.get().getFavoriteEvents().remove(event.get());

    }
}