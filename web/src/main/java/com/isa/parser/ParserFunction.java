package com.isa.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.parser.domain.Event;
import com.isa.parser.domain.Organizer;
import com.isa.parser.domain.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ParserFunction {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    ObjectMapper objectMapper = new ObjectMapper();

    public static final String FILENAME = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/mock/Json_example.json";

    public <T> List<T> parseGenericType(String FILENAME) throws IOException {
        logger.info("Parsing List from filename");
        logger.info("file: " +  FILENAME);
        return objectMapper.readValue(new File(FILENAME), new TypeReference<ArrayList<T>>() {
        });
    }

}
