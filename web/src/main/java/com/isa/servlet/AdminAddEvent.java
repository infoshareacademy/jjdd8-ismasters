package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.dao.EventDao;
import com.isa.dao.UserDao;
import com.isa.domain.entity.Event;
import com.isa.domain.entity.User;
import com.isa.domain.entity.UserType;
import com.isa.mapper.UserMapper;
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
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin/add-event")
public class AdminAddEvent extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Inject
    private EventDao eventDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "admin-add-event.ftlh");
        Map<String, Object> model = new HashMap<>();

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String descShort = req.getParameter("descShort");
        String descLong = req.getParameter("descLong");
        String link = req.getParameter("link");

        logger.info("name {}" , name);
        logger.info("descShort {}" , descShort);
        logger.info("descLong {}" , descLong);
        logger.info("startDate {}" , startDate);
        logger.info("endDate {}" , endDate);

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        LocalDateTime localStartDate =  LocalDate.parse(startDate,formatter).atStartOfDay();
        LocalDateTime localEndDate =  LocalDate.parse(endDate,formatter).atStartOfDay();


        Event event = new Event();
        event.setName(name);
        event.setDescLong(descLong);
        event.setDescShort(descShort);
        event.setStartDate(localStartDate);
        event.setEndDate(localEndDate);

        logger.info("Adding new event");

        eventDao.add(event);

        resp.sendRedirect("/admin/user-list");
    }
}
