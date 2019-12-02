package com.infoshareacademy.Parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Parser {

    ObjectMapper objectmapper = new ObjectMapper();
    Event event;

    {
        try {
            event = objectmapper.readValue(new File("/home/robert/Pulpit/Projekt/jjdd8-ismasters/Example.json"), Event.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Parser p1 = new Parser();
        System.out.println(p1.event);
    }
}
