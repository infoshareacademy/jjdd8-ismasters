package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.service.EventService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/sneak")
public class FavSneakPeak extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private EventService eventService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idParam = req.getParameter("id");
        PrintWriter printWriter = resp.getWriter();

        Long id = Long.parseLong(idParam);
        EventDto eventDto = eventService.userClosestFavEvent(id);

        Template template = templateProvider.getTemplate(getServletContext(),"fav.ftlh");
        Map<String, Object> model = new HashMap<>();

        model.put("eventDto", eventDto);

        try {
            template.process(model, printWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
