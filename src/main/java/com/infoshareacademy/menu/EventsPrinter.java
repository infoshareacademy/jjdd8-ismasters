package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

class EventsPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void printingEvents(List<Event> eventList) {
        ScreenCleaner.cleaningConsoleWindow();
        int eventCounting = 0;
        for (Event event : eventList) {
            stdout.info(event.toString());
            stdout.info("\n");
            eventCounting++;
            eventCounting = eventCounting(eventCounting);
        }
        stdout.info("\nKoniec listy. Wciśnij ENTER, aby kontynuować\n");
        try {
            System.in.read();
        } catch (IOException e) {
            stdout.info("Wystąpił błąd \n" + e);
        }
        eventList.clear();
        ScreenCleaner.cleaningConsoleWindow();
    }

    private static int eventCounting(int eventCounting) {
        if (eventCounting == 5) {
            stdout.info("\n--------Dalej: wciśnij ENTER-------\n");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            eventCounting = 0;
        }
        return eventCounting;
    }
}