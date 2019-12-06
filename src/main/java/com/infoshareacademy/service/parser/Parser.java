package com.infoshareacademy.service.parser;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Event> events = new ArrayList<>();

    public void initialization() {
        Parser parser = new Parser();
        parser.parseData();
    }

    public void parseData() {
        try {
            events = objectMapper.readValue(new File("JSON_example"), new TypeReference<ArrayList<Event>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        EventsRepository.getEvents().addAll(events);
    }
}
