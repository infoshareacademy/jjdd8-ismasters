package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.entity.UserType;
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

@WebServlet ("/noprivileges")
public class NoPrivileges extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "noprivileges.ftlh");
        Map<String, Object> model = new HashMap<>();

        model.put("error", "Dostęp do tej sekcji wymaga uprawnień administratora");

        final String googleId = (String) req.getSession().getAttribute("googleId");
        final String googleEmail = (String) req.getSession().getAttribute("googleEmail");
        final UserType userType = (UserType) req.getSession().getAttribute("userType");
        logger.info("Google email set to {}", googleEmail);

        if (googleId != null && !googleId.isEmpty()) {
            model.put("logged", "yes");
            model.put("googleEmail", googleEmail);
            model.put("userType", userType);
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
