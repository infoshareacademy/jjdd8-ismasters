package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.dto.OrganizerDto;
import com.isa.service.domain.EventService;
import com.isa.service.domain.OrganizersService;
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
import java.util.*;
import java.util.stream.Collectors;


@WebServlet("/organizers-list")
public class ListOfOrganizers extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private OrganizersService organizersService;

    @Inject
    private EventService eventService;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws SecurityException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "organizers-list.ftlh");
        Map<String, Object> model = new HashMap<>();

        Set<OrganizerDto> organizersDtoList = new HashSet<>(organizersService.findAll());

        List<OrganizerDto> filteredOrganizerList = organizersDtoList.stream()
                .filter(e -> eventService.findByOrganizersId(e.getIdDb()).size() > 0)
                .sorted(Comparator.comparing(OrganizerDto::getDesignation))
                .collect(Collectors.toList());


        logger.info("The size of a filtered list  " + filteredOrganizerList.size());

        model.put("organizersDtoList", filteredOrganizerList);

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
            template.process(model, rep.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
