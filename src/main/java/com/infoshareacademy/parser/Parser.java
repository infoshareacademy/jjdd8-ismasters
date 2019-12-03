package com.infoshareacademy.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.Repository.EventMain;

import java.io.File;
import java.io.IOException;

public class Parser {


    public void parsingDataFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Event[] event = null;
        EventMain[] eventMain =null;

        try {
            event = objectMapper.readValue(new File("JSON_example"), Event[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < event.length ; i++) {
            ;
        }
        /*for (Event e : event) {
            System.out.println(e);
        }*/
    }

}
