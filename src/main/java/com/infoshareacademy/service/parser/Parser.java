package com.infoshareacademy.service.parser;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
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

    public void initialization(String filename) {
        Parser parser = new Parser();
        parser.parseData(filename);
    }

    private void parseData(String filename) {
        try {
            events = objectMapper.readValue(new File(filename), new TypeReference<ArrayList<Event>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        EventsRepository.getInstance().getEvents().addAll(events);
    }

    public void parseDataToJson(String filename, Event newEventToBeAdded){
        try{
            objectMapper.writeValue(new File(filename),newEventToBeAdded);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
