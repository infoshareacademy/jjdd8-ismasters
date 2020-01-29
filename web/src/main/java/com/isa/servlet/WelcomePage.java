package com.isa.servlet;


import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.mock.EventDTO_mock;
import com.isa.parser.ApiDataParser;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
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
    private UserAuthenticationService userAuthenticationService = new UserAuthenticationService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        eventDTO_mock.setDescShort("Gimnastyka prozdrowotna dla kobiet 50 +Zaj\u0119cia prozdrowotne i uelastyczniaj\u0105ce dla kobiet 50+.Grupa wiekowa: Kobiety 50+Cena: 20 z\u0142 \u2013 pojedyncze zaj\u0119cia,70 z\u0142 - miesi\u0105c (1x w tygodniu)120 z\u0142 - miesi\u0105c (2x w tygodniu)Cz\u0119stotliwo\u015b\u0107 zaj\u0119\u0107...");
        eventDTO_mock.setName("Gimnastyka prozdrowotna");
        eventDTO_mock.setUrls("http://wyspaskarbow.gak.gda.pl");

        Template template = templateProvider.getTemplate(getServletContext(), "welcome-page.ftlh");
        Map<String, Object> model = new HashMap<>();

        model.put("eventDTO_mock", eventDTO_mock);

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("Content-Type = text/html");

        String code = req.getParameter("code");
        logger.info("Code initial {}", code);
        String state = req.getParameter("state");
        logger.info("State initial {}", state);

        if ( (code != null) && !code.isEmpty() && (state != null) && !state.isEmpty()) {

            if (req.getSession().getAttribute("googleId") == null) {
                String googleJson = userAuthenticationService.getUserInfoJson(code);
                JsonObject googleUser = Json.createReader(new StringReader(googleJson)).readObject();

                logger.info("Google user logged {}", googleUser.getString("email"));
                req.getSession().setAttribute("googleId", googleUser.getString("id"));
            }
        }
            final String googleId = (String) req.getSession().getAttribute("googleId");
            logger.info("GoogleId: {}", googleId);

        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
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
}

