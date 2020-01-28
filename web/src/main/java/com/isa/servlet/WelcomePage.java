package com.isa.servlet;


import com.isa.auth.GoogleAuthHelper;
import com.isa.config.TemplateProvider;
import com.isa.mock.EventDTO_mock;
import com.isa.parser.ApiDataParser;
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


@WebServlet ("")
public class WelcomePage extends HttpServlet {


    public static final String FILENAME = "Json_example.json";


    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private EventDTO_mock eventDTO_mock = new EventDTO_mock();

    @Inject
    private ApiDataParser apiDataParser;

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        eventDTO_mock.setDescShort("Gimnastyka prozdrowotna dla kobiet 50 +Zaj\u0119cia prozdrowotne i uelastyczniaj\u0105ce dla kobiet 50+.Grupa wiekowa: Kobiety 50+Cena: 20 z\u0142 \u2013 pojedyncze zaj\u0119cia,70 z\u0142 - miesi\u0105c (1x w tygodniu)120 z\u0142 - miesi\u0105c (2x w tygodniu)Cz\u0119stotliwo\u015b\u0107 zaj\u0119\u0107...");
        eventDTO_mock.setName("Gimnastyka prozdrowotna");
        eventDTO_mock.setUrls("http://wyspaskarbow.gak.gda.pl");
        Boolean loginStatus;

        final GoogleAuthHelper helper = new GoogleAuthHelper();
        Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
        Map<String, Object> model = new HashMap<>();
        String sessionAttribute = (String) req.getSession().getAttribute("state");

        model.put("eventDTO_mock", eventDTO_mock);
//        model.put("userName", req.getSession().getAttribute("userName"));
//        logger.info("UserName: {}", req.getSession().getAttribute("userName"));
//        logger.info("Session Attributes: {}", req.getSession().getAttributeNames().toString());

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("Content-Type = text/hml");

        if (req.getParameter("code") == null || req.getParameter("state") == null) {
            logger.info("No user logged");


//            writer.println("<a href='" + helper.buildLoginUrl() + "'>log in with google</a>");
            String token = helper.getStateToken();
            req.getSession().setAttribute("state", token);
            logger.info("Token: {}", token);

            sessionAttribute = (String) req.getSession().getAttribute("state");
            model.put("loginUrl", helper.buildLoginUrl());
            model.put("token", token);
            model.put("code", req.getParameter("code"));
            model.put("sessionAttribute", sessionAttribute);

            loginStatus = false;
            model.put("loginStatus", loginStatus);

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                logger.error(e.getMessage());
            }

        } else if (req.getParameter("code") != null && req.getParameter("state") != null
                && req.getParameter("state").equals(sessionAttribute)) {

            req.getSession().setAttribute("admin", true);
            sessionAttribute = (String) req.getSession().getAttribute("state");

            logger.info("User logged");

//            model.put("loginInfo", helper.getUserInfoJson(req.getParameter("state")));
            model.put("state", req.getParameter("state"));
            model.put("code", req.getParameter("code"));
            model.put("sessionAttribute", sessionAttribute);

            loginStatus = true;
            model.put("loginStatus", loginStatus);

            try {
                template.process(model, resp.getWriter());
            } catch (TemplateException e) {
                logger.error(e.getMessage());
            }

        }
    }
}

