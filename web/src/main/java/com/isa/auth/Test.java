package com.isa.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet ("/test")
public class Test extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(getClass().getName());



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Doget invoke");

        final GoogleAuthHelper helper = new GoogleAuthHelper();
        String sessionAttribute = (String) request.getSession().getAttribute("state");
        PrintWriter writer = response.getWriter();
        logger.info("SessionAttribute: {}", sessionAttribute);
        logger.info("0 Code status: {}", request.getParameter("code"));
        logger.info("0 State status: {}", request.getParameter("state"));

        if (request.getParameter("code") == null || request.getParameter("state") == null) {

            logger.info("No user logged");
            logger.info("--------------");

            writer.println("<a href='" + helper.buildLoginUrl() + "'>log in with google</a>");
            String token = helper.getStateToken();
            request.getSession().setAttribute("state", token);
            logger.info("Token: {}", token);

            sessionAttribute = (String) request.getSession().getAttribute("state");
            logger.info("SessionAttribute: {}", sessionAttribute);
            logger.info("1 Code status: {}", request.getParameter("code"));
            logger.info("1 State status: {}", request.getParameter("state"));
//            writer.println(helper.getUserInfoJson(request.getParameter("state")));

        } else if (request.getParameter("code") != null && request.getParameter("state") != null
                && request.getParameter("state").equals(sessionAttribute)) {

            request.getSession().setAttribute("admin", true);

            logger.info("User logged");
            logger.info("-----------");


            logger.info("2 Code status: {}", request.getParameter("code"));
            logger.info("2 State status: {}", request.getParameter("state"));

            writer.println(helper.getUserInfoJson(request.getParameter("code")));
            writer.println("State " + request.getParameter("state"));
            writer.println("<br>");
            writer.println("Code " + request.getParameter("code"));

        }

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        logger.info("Do POST");
    }

    @Override
    protected void doDelete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        logger.info("Do DELETE");
    }
    @Override
    protected void doPut(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        logger.info("Do PUT");
    }
}
