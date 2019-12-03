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
        EventMain eventMain = null;

        try {
             event = objectMapper.readValue(new File("JSON_example"), new TypeReference<ArrayList<Event>>() {});

        } catch (IOException e) {
            e.printStackTrace();
        }

        //eventMain = new ArrayList<EventMain>(e.getPlace(), e.getEndDate(), e.getName(), e.getStartDate(), e.getOrganizer());
        for (Event e : event) {

            eventMain = new eventMain(e.getPlace(), e.getEndDate(), e.getName(), e.getStartDate(), e.getOrganizer());
        }

    }

    public static void main(String[] args) {
        Parser p1 = new Parser();
        p1.parsingDataFromJson();
    }

}
