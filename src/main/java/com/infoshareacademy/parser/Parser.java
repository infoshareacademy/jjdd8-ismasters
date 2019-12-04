package com.infoshareacademy.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.repository.EventsRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Event> event = new ArrayList<>();


    public void parsingDataFromJson() {
        try {
            event = objectMapper.readValue(new File("JSON_example"), new TypeReference<ArrayList<Event>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        EventsRepository.events.addAll(event);
    }

}
