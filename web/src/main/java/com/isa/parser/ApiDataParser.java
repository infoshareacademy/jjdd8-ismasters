package com.isa.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ApiDataParser {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    ObjectMapper objectMapper = new ObjectMapper();


    public <T> List<T> parse(String FILENAME) throws IOException {
        logger.info("Parsing List from filename");
        logger.info("file: " +  FILENAME);
        return objectMapper.readValue(new File(FILENAME), new TypeReference<ArrayList<T>>() {
        });
    }

}
