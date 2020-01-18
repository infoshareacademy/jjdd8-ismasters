package com.isa.servlet;

import com.isa.config.TemplateProvider;
import com.isa.service.ApiInitialization;
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

        Part json_file = req.getPart("json_file");
        String filePath = "";
        try {
            filePath = fileUploadProcessor.getUploadFilePath() + fileUploadProcessor.uploadFile(json_file).getName();
            writer.println("Plik " + filePath + " został załadowany");
        } catch (Exception e) {
            logger.warn("Upload file not found: " + e.getMessage());
        }

        req.getSession().setAttribute("JsonFilePath", filePath);
        logger.info("Events.json file path set to: " + filePath);


    }

    private void setEncoding(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }
}
