package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.service.FileUploadProcessor;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
@WebServlet ("/admin/upload")
public class JsonFileUpload extends HttpServlet {

    @Inject
    private FileUploadProcessor fileUploadProcessor;

    @Inject
    private TemplateProvider templateProvider;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Session id: " + req.getSession().getId());
        setEncoding(req, resp);
        logger.info("Json file upload form opened");
        Template template = templateProvider.getTemplate(getServletContext(), "json_file_uploader.ftlh");
        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncoding(req, resp);
        logger.info("Session id: " + req.getSession().getId());
        logger.info("doPost invoked");
        PrintWriter writer = resp.getWriter();

        Part EventsJson = req.getPart("events");
        Part PlacesJson = req.getPart("places");
        Part OrganizersJson = req.getPart("organizers");
        String EventsFilePath = "";
        String PlacesFilePath = "";
        String OrganizersFilePath = "";
        try {
            EventsFilePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(EventsJson).getName();
            PlacesFilePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(PlacesJson).getName();
            OrganizersFilePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(OrganizersJson).getName();
            writer.println("Plik " + EventsFilePath + " został załadowany");
            writer.println("Plik " + OrganizersFilePath + " został załadowany");
            writer.println("Plik " + PlacesFilePath + " został załadowany");
        } catch (Exception e) {
            logger.warn("Upload file not found: " + e.getMessage());
        }

        req.getSession().setAttribute("EventsFilePath", EventsFilePath);
        req.getSession().setAttribute("PlacesFilePath", PlacesFilePath);
        req.getSession().setAttribute("OrganizersFilePath", OrganizersFilePath);
        logger.info("Events.json file path set to: " + EventsFilePath);
        logger.info("Organizer.json file path set to: " + OrganizersFilePath);
        logger.info("Places.json file path set to: " + PlacesFilePath);


    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}
