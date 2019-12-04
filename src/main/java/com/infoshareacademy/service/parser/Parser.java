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

    public void parseData() {
        try {
            events = objectMapper.readValue(new File("JSON_example"), new TypeReference<ArrayList<Event>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Event e : events) {
            System.out.println(e);
        }

        EventsRepository.getEvents().addAll(events);
    }

    public static void main(String[] args) {
        Parser p1 = new Parser();
        p1.parseData();
    }

}
