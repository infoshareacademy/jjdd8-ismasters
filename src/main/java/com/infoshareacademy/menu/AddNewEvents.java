package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.domain.parser.Organizer;
import com.infoshareacademy.domain.parser.Place;
import com.infoshareacademy.domain.parser.Urls;
import com.infoshareacademy.menu.util.DateValidator;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.service.parser.Parser;
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
    public static int randomNewId;
    public final static String EMPTY_STRING = "";
    public final static Integer EMPTY_INTEGER = 0;


    DateValidator dateValidator = new DateValidator();

    public  void addNewEvent() {
        stdout.info("\n" + "Operacja dodawania nowego wydarzenia" + "\n");
        collectEventsName();
        collectPlaceSubname();
        collectPlaceName();
        collectStartDate();
        collectStartTime();
        collectOrganizersDesignation();
        collectUrlWww();

        EventsRepository.getInstance().getEvents().add(createNewEvent());
        findEventWithNewId();

        Parser parser = new Parser();
        parser.parseDataToJson();

    }

    public  Event createNewEvent(){
       return new Event(giveNewId(), createNewPlace(), EMPTY_STRING, newEventName, createNewUrls(), null,
               EMPTY_STRING, EMPTY_INTEGER, newStartDate + "T" + newStartTime, createNewOrganizer(), EMPTY_INTEGER, EMPTY_STRING, null);
    }

    public  Organizer createNewOrganizer(){
        return new Organizer(EMPTY_INTEGER,newOrganizerDesignation);
    }

    public  Urls createNewUrls(){
        return new Urls(newWWW, EMPTY_STRING, EMPTY_STRING);
    }

    public  Place createNewPlace(){
        return new Place(EMPTY_INTEGER, newPlaceSubname, newPlaceName);
    }

    public  String collectUrlWww() {
        do {
            stdout.info("\n" + "Podaj strone internetową" + "\n");
            newWWW = Menu.scanner.nextLine();
            if (newWWW.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
        } while ((newWWW.length() < 3));
        return newWWW;
    }

    public  String collectOrganizersDesignation() {
        do {
            stdout.info("\n" + "Podaj organizatora" + "\n");
            newOrganizerDesignation = Menu.scanner.nextLine();
            if (newOrganizerDesignation.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
        } while ((newOrganizerDesignation.length() < 3));
        return newOrganizerDesignation;
    }

    public  String collectStartTime() {

        stdout.info("Podaj Start godzine w formacie HH:MM do wyszukania i wciśnij ENTER\n");
        newStartTime = Menu.scanner.nextLine();

        return newStartTime;
    }

    public  String collectStartDate() {
        do {
            stdout.info("Podaj  Start datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER\n");
            newStartDate = Menu.scanner.nextLine();
            if (!dateValidator.isDateValid(newStartDate)) {
                stdout.info("\nZły format daty!\n\n");
            }
        } while (!dateValidator.isDateValid(newStartDate));
        return newStartDate;
    }

    public  String collectPlaceName() {
        do {
            stdout.info("\n" + "Podaj miejsca wydarzenia" + "\n");
            newPlaceName = Menu.scanner.nextLine();
            if (newPlaceName.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
        } while ((newPlaceName.length() < 3));
        return newPlaceName;
    }

    public  String collectPlaceSubname() {
        do {
            stdout.info("\n" + "Podaj opis miejsca wydarzenia" + "\n");
            newPlaceSubname = Menu.scanner.nextLine();
            if (newPlaceSubname.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
        } while ((newPlaceSubname.length() < 3));
        return newPlaceSubname;
    }

    public  String collectEventsName() {
        do {
            stdout.info("\n" + "Podaj nazwe wydarzenia" + "\n");
            newEventName = Menu.scanner.nextLine();
            if (newEventName.length() < 3) {
                stdout.info("Wpisz co najmniej 3 znaki\n");
            }
        } while ((newEventName.length() < 3));
        return newEventName;
    }

    public  List<Integer> listEventsIds() {
        for (Event event : EventsRepository.getInstance().getEvents()) {
            listOfEventsIds.add(event.getid());
        }
        return listOfEventsIds;
    }

    public  Integer giveNewId() {
        Integer maxIdFromList = Collections.max(listEventsIds());
        randomNewId = maxIdFromList + 1;
        return randomNewId;
    }

    public static void removeIdFromList(Integer idToRemove) {
        listOfEventsIds.remove(listOfEventsIds.get(idToRemove));
    }

    public  void findEventWithNewId(){
        for (Event event : EventsRepository.getInstance().getEvents()) {
            if (event.getid() == randomNewId){
                stdout.info("\n" + "Nowe wydarzenie o ID " + randomNewId + " zostało dodane" +"\n");
            }
        }
    }

}
