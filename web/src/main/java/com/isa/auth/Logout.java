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


@WebServlet ("/logout")
public class Logout extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(getClass().getName());


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Doget invoke");

        final GoogleAuthHelper helper = new GoogleAuthHelper();

        PrintWriter writer = response.getWriter();

        logger.info("0 Code status: {}", request.getParameter("code"));
        logger.info("0 State status: {}", request.getParameter("state"));

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("Content-Type = text/hml");

        Boolean isLogged = (Boolean) request.getSession().getAttribute("admin");

        if (!isLogged) {

            logger.info("No user logged");
            response.sendRedirect("/");
        } else {
            request.getSession().setAttribute("admin", false);
            logger.info("User logged out");

            String callbackUri = request.getRequestURI();
            response.sendRedirect(callbackUri);
        }
    }
}
