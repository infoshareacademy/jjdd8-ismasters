package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddNewEvents {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    public static List<Integer> listOfEventsIds = new ArrayList<>();
    public static String newEventName;
    public static String newPlaceSubname;
    public static String newPlaceName;
    public static String newStartDate;
    public static String newStartTime;
    public static String newOrganizerDesignation;
    public static String newWWW;
    public static String searchString;
    public static int randomNewId;
    static String searchStringEvent = "";

    public static void addNewEvent() {
        stdout.info("\n" + "Operacja dodawania nowego wydarzenia" + "\n");
        addEventsName();

    }

    public static String addEventsName() {
        do {
            stdout.info("\n" + "Podaj nazwe wydarzenia" + "\n");
            newEventName = Menu.scanner.nextLine();
            if (newEventName.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
        } while ((newEventName.length() < 3));
        return newEventName;
    }

    public static List<Integer> listEventsIds() {
        for (Event event : EventsRepository.getInstance().getEvents()) {
            listOfEventsIds.add(event.getid());
        }
        return listOfEventsIds;
    }

    public static Integer giveNewId() {
        Integer maxIdFromList = Collections.max(listEventsIds());
        Integer newId = maxIdFromList + 1;
        //listOfEventsIds.add(maxIdFromList + 1);
        return newId;
    }

    public static void removeIdFromList(Integer idToRemove) {
        listOfEventsIds.remove(listOfEventsIds.get(idToRemove));
    }

}
