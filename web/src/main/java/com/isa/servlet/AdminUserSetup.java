package com.isa.servlet;


import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.dao.UserDao;
import com.isa.domain.dto.UserDto;
import com.isa.domain.entity.Event;
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
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Transactional
@WebServlet ("/admin/user-list")
public class AdminUserSetup extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    UserAuthenticationService userAuthenticationService;

    @Inject
    UserService userService;

    @Inject
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "admin-user-list.ftlh");

        setEncoding(req, resp);

        List<UserDto> userDtoList = new ArrayList<>();
        userDtoList.addAll(userService.getUsers());

        Map<String, Object> model = new HashMap<>();
        model.put("userDtoList", userDtoList);

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
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("Request DELETE method");
        String id = req.getParameter("id");
        Long userId = Long.parseLong(id);

        User user = userService.findUserById(userId);
        userDao.removeUser(user);

    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

}
