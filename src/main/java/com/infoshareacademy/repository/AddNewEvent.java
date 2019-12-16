package com.infoshareacademy.repository;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.domain.parser.Organizer;
import com.infoshareacademy.domain.parser.Place;
import com.infoshareacademy.domain.parser.Urls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class AddNewEvent {

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

    public void addNewEvent(){

        stdout.info("\n--------Dodawanie nowego Wydarzenia-------\n");
        stdout.info("\n--------Podaj nazwę nowego Wydarzenia-------\n");
        newEventName = scanner.nextLine();
        stdout.info("\n--------Podaj nazwę miejsca Wydarzenia-------\n");
        newPlaceName = scanner.nextLine();
        stdout.info("\n--------Podaj dokłądne miejsce wydarzenia-------\n");
        newPlaceSubname = scanner.nextLine();
        stdout.info("\n--------Podaj datę Wydarzenia wskazany format YYYY-MM-DD-------\n");
        newStartDate = scanner.nextLine();
        stdout.info("\n--------Podaj godzine Wydarzenia wskazany format HH-MM-------\n");
        newStartTime = scanner.nextLine();
        stdout.info("\n--------Podaj nazwę organizatora-------\n");
        newOrganizerDesignation = scanner.nextLine();
        stdout.info("\n--------Podaj nazwę strony www-------\n");
        newWWW = scanner.nextLine();

        EventsRepository.getEvents().add(new Event(randomNewId, new Place(newPlaceSubname,newPlaceName), newEventName, new Urls(newWWW), newStartDate + "T" + newStartTime, new Organizer(newOrganizerDesignation)));


        EventsRepository.getEvents().stream().filter(p->p.getName().contains(newEventName)).peek(s -> stdout.info("Gratuluje nowe wydarzenie umieszczone w spisie")).orElse("");


    }


}
