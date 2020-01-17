package com.isa.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/fakeadmin")
public class FakeAdminServlet extends HttpServlet {
    //this class is temporary
    //TODO Grzesiek delete this class after login system is implemented

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        logger.info("Session id: " + req.getSession().getId());

        String adminStatus = null;
//        try {
            adminStatus = req.getParameter("admin");
//        } catch (NullPointerException e) {
//            logger.error("Admin parameter is null. \n {}", e.getMessage());
//        }

        if (adminStatus == null || adminStatus.isEmpty()) {
            writer.println("Podaj parametr, aby ustawić status administratora");
        } else {
            logger.info("Passed admin value: {}", adminStatus);
            if (adminStatus.equals("true")) {
                req.getSession().setAttribute("admin", "true");
                logger.info("Session attribute admin set to: {}", req.getSession().getAttribute("admin"));
            } else {
                req.getSession().setAttribute("admin", "false");
                logger.info("Session attribute admin set to: {}", req.getSession().getAttribute("admin"));
            }
        }

    }
}
