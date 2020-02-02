package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.entity.User;
import com.isa.domain.entity.UserType;
import com.isa.service.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/admin/edit-user")
public class AdminEditUser extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

        setEncoding(req, resp);

        Template template = templateProvider.getTemplate(getServletContext(), "admin-edit-user.ftlh");
        Map<String, Object> model = new HashMap<>();

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

        String requestParamId = req.getParameter("id");
        logger.info("UserEdit");
        logger.info("ID in request: " + requestParamId);

        long userId = 0L;

        if (requestParamId == null || requestParamId.isEmpty()) {
            model.put("error", "Błędny parametr id");
        } else {
            try {
                userId = Long.parseLong(requestParamId);
                logger.info("User id: " + requestParamId);
            } catch (NumberFormatException e) {
                logger.error("Błędny parametr id usera {}", e.getMessage());
            }
        }

        if (userId != 0L) {
            User user = userService.findUserById(userId);

            if (user != null) {
                logger.info("User found:" + user.getClass().getName());
                logger.info("ID found: " + user.getId());
                logger.info("name found: " + user.getName());
                logger.info("email found: " + user.getEmail());
                logger.info("userType found: " + user.getUserType());

                model.put("id", user.getId());
                model.put("name", user.getName());
                model.put("email", user.getEmail());
                model.put("userType", user.getUserType());


                try {
                    template.process(model, resp.getWriter());
                } catch (TemplateException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Invoke POST ---------------------------------");
        setEncoding(req, resp);

        Map<String, Object> model = new HashMap<>();

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

        logger.info("Id z formularza {}", req.getParameter("id"));
        Long userId = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String userRole = req.getParameter("userType");


        logger.info("doPut form data");
        logger.info("Id: " + userId);
        logger.info("Name: " + name);
        logger.info("Email: " + email);
        logger.info("userType: " + userRole);

        User user = userService.findUserById(userId);
        user.setName(name);
        user.setEmail(email);

        if (userRole.equals("ADMIN")) {
            user.setUserType(UserType.ADMIN);
        } else if (userRole.equals("SUPER_ADMIN")) {
            user.setUserType(UserType.SUPER_ADMIN);
        } else
            user.setUserType(UserType.USER);

        userService.editUser(user);
        logger.info("User saved---------");
        resp.sendRedirect("/admin/user-list");

    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws
            UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}
