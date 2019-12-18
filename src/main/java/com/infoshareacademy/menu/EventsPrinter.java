package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class EventsPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void printEvents(List<Event> eventList) {
        ScreenCleaner.cleanConsoleWindow();
        int countEvents = 0;
        for (Event event : eventList) {
            stdout.info(event.toString());
            stdout.info("\n");
            countEvents++;
            countEvents = countEvents(countEvents);
        }
        stdout.info("\nKoniec listy. Wciśnij ENTER, aby kontynuować\n");
        try {
            System.in.read();
        } catch (IOException e) {
            stdout.info("Wystąpił błąd \n" + e);
        }
        eventList.clear();
        ScreenCleaner.cleanConsoleWindow();
    }

    private static int countEvents(int countEvents) {
        if (countEvents == 5) {
            stdout.info("\n--------Dalej: wciśnij ENTER-------\n");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            countEvents = 0;
        }
        return countEvents;
    }


}

