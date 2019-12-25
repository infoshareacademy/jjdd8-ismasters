package com.isa.servlet;

import com.isa.config.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@WebServlet ("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(WelcomeUserServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "welcome-user.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("name", name);

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
             logger.severe(e.getMessage());
        }

    }
}
