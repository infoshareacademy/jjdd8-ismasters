package com.isa.servlet;

import com.isa.config.TemplateProvider;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String name = req.getParameter("name");
        if (name == null || name.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            logger.error("Bad request");
            logger.debug("Bad request");
            return;
        }

        Template template = templateProvider.getTemplate(getServletContext(), "welcome-user.ftlh");

        Map<String, Object> model = new HashMap<>();
        model.put("name", name);

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
