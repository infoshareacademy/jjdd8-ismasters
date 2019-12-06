package com.infoshareacademy;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.repository.FilterRepository;
import com.infoshareacademy.service.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.initialization();
        for (Event e : EventsRepository.getEvents() ) {
            System.out.println(e.toString());
        }
    }
}