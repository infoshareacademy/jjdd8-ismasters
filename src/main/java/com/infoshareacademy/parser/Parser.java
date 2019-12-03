package com.infoshareacademy.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Parser {

    public void parsingDataFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        Event[] event = null;

        try {
            event = objectMapper.readValue(new File("JSON_example"), Event[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Event e : event) {
            System.out.println(e);
        }
    }

}
