package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class EventsPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void printEvents(List<Event> eventList) {
        ScreenCleaner.cleanConsole();
        int eventCounter = 0;
        for (Event event : eventList) {
            stdout.info(event.toString());
            stdout.info("\n");
            eventCounter++;
            if (eventCounter == 5) {
                stdout.info("\n--------Dalej: wciśnij ENTER-------\n");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                eventCounter = 0;
            }
        }
        stdout.info("\nKoniec listy. Wciśnij ENTER, aby kontynuować\n");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        eventList.clear();
        ScreenCleaner.cleanConsole();
    }
}
