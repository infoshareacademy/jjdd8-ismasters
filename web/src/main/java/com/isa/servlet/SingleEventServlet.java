package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.mock.EventDTO;
import com.isa.service.SingleEventService;
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

@WebServlet ("/single")
public class SingleEventServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private SingleEventService singleService;

//    @Inject
//    EventDTO_mock dto;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

//        String event = req.getParameter("event");
//        if (event == null || event.isEmpty()) {
//            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            logger.error("Bad request");
//            logger.debug("Bad request");
//            return;
//        }

        Template template = templateProvider.getTemplate(getServletContext(),"singleEvent-section.ftlh");

//        Object model = singleService.toSingleEvent();


        Object model = singleService.getSingleEvent();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }

        System.out.println("Error: " + logger.isErrorEnabled());
        logger.error("Test error log");
        System.out.println("Warn: " + logger.isWarnEnabled());
        logger.warn("Test warn log");
        System.out.println("Info: " + logger.isInfoEnabled());
        logger.info("Test info log");
        System.out.println("Debug: " + logger.isDebugEnabled());
        logger.debug("Test debug log");
        System.out.println("Trace: " + logger.isTraceEnabled());
        logger.trace("Test trace log");
    }
}
