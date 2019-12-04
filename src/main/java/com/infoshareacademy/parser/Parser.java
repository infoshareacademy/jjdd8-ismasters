package com.infoshareacademy.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.Repository.EventMain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {


    public void parsingDataFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Event> event = null;
        ArrayList<EventMain> eventMain = new ArrayList<>();

        try {
            event = objectMapper.readValue(new File("JSON_example"), new TypeReference<ArrayList<Event>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Event e : event) {
            System.out.println(e);
            eventMain.add(new EventMain(e.getPlace(), e.getEndDate(), e.getName(), e.getStartDate(), e.getOrganizer()));
        }
        for (EventMain f : eventMain) {
            System.out.println(f.toString());// -> why null ??
        }


    }

    public static void main(String[] args) {
        Parser p1 = new Parser();
        p1.parsingDataFromJson();
    }

}
