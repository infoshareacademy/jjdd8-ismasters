package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.service.PaginationService;
import com.isa.service.constant.PageEventSize;
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
@WebServlet("/list-events")
public class ListOfEvents extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Inject
    private PageEventSize pageEventSize;

    @Inject
    private PaginationService paginationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws SecurityException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "event-list.ftlh");
        Map<String, Object> model = new HashMap<>();

        String pageNumber = req.getParameter("pageNumber") ;
        String pageSize = req.getParameter("pageSize");

        int  pageNum = Integer.parseInt(pageNumber);

        int next = paginationService.add(pageNum);

        int previous = paginationService.reduce(pageNum);

        int lastPageView = paginationService.getLastPage();


        List<EventDto> eventDtoList = new ArrayList<>();

        eventDtoList.addAll(eventService.getEventsForView(pageNum,20));

        logger.info("The size of a arraylist " + eventDtoList.size());

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
