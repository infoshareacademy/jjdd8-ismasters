package com.infoshareacademy.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Parser {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Event event = null;
        try {
            event = objectMapper.readValue(new File("Example"), Event.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(event.toString());

    }

}
