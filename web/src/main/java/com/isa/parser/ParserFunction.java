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


    public List<Event> eventList(String filename) throws IOException {
        logger.info("Parsing event List from filename");
        return objectMapper.readValue(new File(filename), new TypeReference<ArrayList<Event>>() {
        });
    }

    public List<Organizer> organizersList(String filename) throws IOException {
        logger.info("Parsing organizers List from filename");
        return objectMapper.readValue(new File(filename), new TypeReference<ArrayList<Organizer>>() {
        });
    }

    public List<Place> placeList(String filename) throws IOException {
        logger.info("Parsing place List from filename");
        return objectMapper.readValue(new File(filename), new TypeReference<ArrayList<Place>>() {
        });
    }


}
