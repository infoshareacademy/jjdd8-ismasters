package com.infoshareacademy.repository;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.domain.parser.Organizer;
import com.infoshareacademy.domain.parser.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AddingNewEvent {


    String newEventName;
    String newPlaceSubname;
    String newPlaceName;
    String newStartDate;
    String newStartTime;
    String newOrganizerDesignation;
    String newWWW;
    int randomNewId;

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    Scanner scanner = new Scanner(System.in);

    public void addNewEvent() {
        Event newEvent = new Event();
        Organizer newOrganizer = new Organizer();
        Place newPlace = new Place();
        String inputString;
        stdout.info("\n--------Dodawanie nowego Wydarzenia-------\n");
        stdout.info("\n--------Podaj nazwę nowego Wydarzenia-------\n");
        newEvent.setName(scanner.nextLine());

        stdout.info("\n--------Podaj nazwę miejsca Wydarzenia-------\n");
        inputString  = scanner.nextLine();
        newOrganizer.setDesignation(inputString);

        stdout.info("\n--------Podaj dokłądne miejsce wydarzenia-------\n");
        inputString  = scanner.nextLine();
        newPlace.setSubname(inputString);

        stdout.info("\n--------Podaj datę Wydarzenia wskazany format YYYY-MM-DD-------\n");
        newStartDate = scanner.nextLine();

        stdout.info("\n--------Podaj godzine Wydarzenia wskazany format HH-MM-------\n");
        newStartTime = scanner.nextLine();
        newEvent.setStartDate(newStartDate+"T"+newStartTime);

        stdout.info("\n--------Podaj nazwę organizatora-------\n");
        newOrganizerDesignation = scanner.nextLine();

        stdout.info("\n--------Podaj nazwę strony www-------\n");
        newWWW = scanner.nextLine();


        //EventsRepository.getInstance().getEvents().add(E)
        //EventsRepository.getInstance().getEvents().add(Eventnew Event(randomNewId, new Place(newPlaceSubname,newPlaceName), newEventName, new Urls(newWWW), newStartDate + "T" + newStartTime, new Organizer(newOrganizerDesignation)));


        // EventsRepository.getInstance().getEvents().stream().filter(p->p.getName().contains(newEventName)).peek(s -> stdout.info("Gratuluje nowe wydarzenie umieszczone w spisie"));
    }
}
