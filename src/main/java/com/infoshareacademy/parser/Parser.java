package com.infoshareacademy.parser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();
        Event[] event = null;
        //ArrayList<> events = new ArrayList<>[]();
        try {
            event = objectMapper.readValue(new File("/home/robert/Pulpit/Projekt/jjdd8-ismasters/JSON_example"), Event[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Event e:event) {
            System.out.println(e);
        }

    }
}
