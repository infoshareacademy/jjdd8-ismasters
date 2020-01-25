package com.isa.servlet;

import com.isa.config.TemplateProvider;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet ("/home")
public class AdminServlet extends HttpServlet {

    private static final String USER_TYPE = "userType";
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userType;

        if (req.getSession().getAttribute(USER_TYPE) == null) {
            userType = "guest";
        } else {
            userType = String.valueOf(req.getSession().getAttribute(USER_TYPE));
        }

        Template template = templateProvider.getTemplate(getServletContext(), "admin.ftlh");


        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put(USER_TYPE, userType);
        dataModel.put("function", "HomePage");

        PrintWriter printWriter = resp.getWriter();

        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

}