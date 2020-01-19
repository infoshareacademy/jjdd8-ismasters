package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.service.EventService;
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

@WebServlet ("/single")
public class SingleEventServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idParam = req.getParameter("id");
        PrintWriter writer = resp.getWriter();

        if (idParam == null || idParam.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Long id = Long.parseLong(idParam);
        EventDto eventDto = eventService.findById(id);

        Template template = templateProvider.getTemplate(getServletContext(),"bootstrapsingleevent.ftlh");
        Map<String, Object> model = new HashMap<>();

        if (eventDto != null) {
            model.put("eventDto", eventDto);
        } else {
            model.put("errorMessage", "Event nie znaleziony");
        }

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
