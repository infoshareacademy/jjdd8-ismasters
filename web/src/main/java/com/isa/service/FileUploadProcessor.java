package com.isa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@RequestScoped
public class FileUploadProcessor {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    String SETTINGS_FILE = "settings.properties";

    public String getUploadFilePath() throws IOException {

        Properties settings = new Properties();

        settings.load(Thread.currentThread().getContextClassLoader().getResource(SETTINGS_FILE).openStream());
        String fileUploadPath = settings.getProperty("Upload.Path.Images");
        logger.info("File upload path : {}", fileUploadPath);
        return fileUploadPath;
    }

    public File uploadFile(Part filePart) throws IOException {

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        logger.info("File upload name {}", fileName);

        if (fileName == null || fileName.isEmpty()) {
            logger.error("Upload file error");
            throw new IOException("File error");
        }

        File file = new File(fileName);
        Files.deleteIfExists(file.toPath());

        InputStream fileContent = filePart.getInputStream();

        Files.copy(fileContent, file.toPath());
        fileContent.close();

        return file;
    }
}
