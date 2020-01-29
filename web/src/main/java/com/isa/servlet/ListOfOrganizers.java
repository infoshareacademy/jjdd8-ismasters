package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.domain.dto.OrganizerDto;
import com.isa.service.PaginationService;
import com.isa.service.constant.PageEventSize;
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

/**
 *
 */
@WebServlet("/organizers-list")
public class ListOfOrganizers extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

   @Inject
    private OrganizersService organizersService;

    @Inject
    private PageEventSize pageEventSize;

    @Inject
    private PaginationService paginationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws SecurityException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "organizers-list.ftlh");
        Map<String, Object> model = new HashMap<>();


        Set<OrganizerDto> organizersDtoList = new HashSet<>(organizersService.findAll());

        logger.info("The size of a arraylist " + organizersDtoList.size());

        model.put("organizersDtoList", organizersDtoList);

        try {
            template.process(model, rep.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }



}
