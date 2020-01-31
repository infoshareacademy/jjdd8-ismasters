package com.isa.parser;

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

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> List<T> parse(String json, Class<T> tClass) throws IOException {
        logger.info("Parsing List from filename");

        return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
    }

    public <T> List<T> parseFromFile(String json, Class<T> tClass) throws IOException {
        logger.info("Parsing List from filename");

        return objectMapper.readValue(new File(json), objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass));
    }

}
