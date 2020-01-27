package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.service.ConverterRequest;
import com.isa.service.FileUploadProcessor;
import com.isa.service.manager.EventManager;
import com.isa.service.manager.OrganizersManager;
import com.isa.service.manager.PlaceManager;
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

    @Inject
    private EventManager eventManager;

    @Inject
    private OrganizersManager organizersManager;

    @Inject
    private ConverterRequest converter;

    @Inject
    private PlaceManager placeManager;


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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            setEncoding(req, resp);
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("Session id: " + req.getSession().getId());
        logger.info("doPost invoked");

        PrintWriter writer = null;
        Part eventsJson = null;
        Part placesJson = null;
        Part organizersJson = null;
        try {
            writer = resp.getWriter();

            eventsJson = req.getPart("events");
            placesJson = req.getPart("places");
            organizersJson = req.getPart("organizers");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        String eventsFilePath = "";
        String placesFilePath = "";
        String organizersFilePath = "";

        try {
            eventsFilePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(eventsJson).getName();
            placesFilePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(placesJson).getName();
            organizersFilePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(organizersJson).getName();
            writer.println("Plik " + eventsFilePath + " został załadowany");
            writer.println("Plik " + organizersFilePath + " został załadowany");
            writer.println("Plik " + placesFilePath + " został załadowany");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        logger.info("Events.json file path set to: " + eventsFilePath);
        logger.info("Organizer.json file path set to: " + organizersFilePath);
        logger.info("Places.json file path set to: " + placesFilePath);

        organizersManager.setRelationsFromFile(organizersFilePath);
        placeManager.setRelationsFromFile(placesFilePath);
        eventManager.setRelationsFromFileToEntity(eventsFilePath);

    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}
