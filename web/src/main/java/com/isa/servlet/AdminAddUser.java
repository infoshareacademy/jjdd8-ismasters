package com.isa.servlet;

import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.dao.UserDao;
import com.isa.domain.dto.UserDto;
import com.isa.domain.entity.User;
import com.isa.domain.entity.UserType;
import com.isa.mapper.UserMapper;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/admin/add-user")
public class AdminAddUser extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Inject
    private UserService userService;

    @Inject
    private UserMapper userMapper;

    @Inject
    private UserDao userDao;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "admin-add-new-user.ftlh");
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

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String userRole= req.getParameter("userRole");


        logger.info("---Name: {}", name);
        logger.info("---Email: {}", mail);
        logger.info("---Role: {}", userRole);

        User user = new User();
        user.setName(name);
        user.setEmail(mail);
        if ("ADMIN".equals(userRole)) {
            user.setUserType(UserType.ADMIN);
        } else {
            user.setUserType(UserType.USER);
        }
//        userService.createNewUser();

        logger.info("Name: {}", user.getName());
        logger.info("Email: {}", user.getEmail());
        logger.info("Role: {}", user.getUserType());

        userDao.add(user);

        resp.sendRedirect("/admin/user-list");
    }
}
