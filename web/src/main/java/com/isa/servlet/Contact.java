package com.isa.servlet;


import com.isa.auth.UserAuthenticationService;
import com.isa.config.TemplateProvider;
import com.isa.domain.dto.EventDto;
import com.isa.domain.dto.UserDto;
import com.isa.domain.entity.UserType;
import com.isa.mock.EventDTO_mock;
import com.isa.service.UserService;
import com.isa.service.domain.EventService;
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
import java.util.*;


@WebServlet("/contact")
public class Contact extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private UserService userService;

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private UserAuthenticationService userAuthenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "contact.ftlh");
        Map<String, Object> model = new HashMap<>();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("Content-Type = text/html");

        String code = req.getParameter("code");
        String state = req.getParameter("state");

        if ((code != null) && !code.isEmpty() && (state != null) && !state.isEmpty()) {

            if (req.getSession().getAttribute("googleId") == null) {
                String googleJson = userAuthenticationService.getUserInfoJson(code);
                JsonObject googleUser = Json.createReader(new StringReader(googleJson)).readObject();

                String googleUserEmail = googleUser.getString("email");
                String googleUserId = googleUser.getString("id");

                logger.info("Google user logged {}\n", googleUserEmail);

                if (userService.userExists(googleUserEmail)) {

                    Optional<UserDto> userDto = userService.getUserByEmail(googleUserEmail);
                    logger.info("UserType from DB {}", userDto.get().getUserType());

                    req.getSession().setAttribute("userType", userDto.get().getUserType());
                    req.getSession().setAttribute("googleId", userDto.get().getGoogleId());
                    req.getSession().setAttribute("googleEmail", userDto.get().getEmail());

                    logger.info("Usertype from db {}", req.getSession().getAttribute("userType"));
                    logger.info("Googleid from db {}", req.getSession().getAttribute("googleId"));
                    logger.info("GoogleEmail from db {}", req.getSession().getAttribute("googleEmail"));

                } else {

                    UserDto userDto = new UserDto();
                    userDto.setGoogleId(googleUserId);
                    userDto.setEmail(googleUserEmail);
                    userDto.setUserType(UserType.USER);

                    userService.createNewUser(userDto);

                    req.getSession().setAttribute("userType", userDto.getUserType());
                    req.getSession().setAttribute("googleId", userDto.getGoogleId());
                    req.getSession().setAttribute("googleEmail", userDto.getEmail());

                    logger.info("Usertype sent to DB {}", userDto.getUserType());
                    logger.info("Googleid sent to DB {}", userDto.getGoogleId());
                    logger.info("GoogleEmail sent to DB {}\n", userDto.getEmail());
                }
            }
        }
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

