package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.domain.parser.Organizer;
import com.infoshareacademy.domain.parser.Place;
import com.infoshareacademy.domain.parser.Urls;
import com.infoshareacademy.repository.EventsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

import static com.infoshareacademy.menu.EventsPrinter.printingEvents;

public class ManagingEvents {


    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    static String addingNewEvent = "Dodawanie nowego Wydarzenia";
    static String editingAnEvent = "Edytowanie wydarzenia";
    static String deletingAnEvent = "Usuwanie wydarzeń";
    static String addingToFavorite = "Dodanie do ulubionych";

    int mainExitCode = 0;

    public void eventManaging(){

        while (mainExitCode != 9) {
            MenuBuilder.menuBuilderPrinting();

            switch (ChoiceGetter.getChoice()) {
                case 1:
                    printingEvents(filterRepository.allEvents());
                    stdout.info("\n");
                    break;
                case 2:
                    ScreenCleaner.cleaningConsoleWindow();
                    new NearestEvents().showNearestEvents();
                    break;
                case 3:
                    ScreenCleaner.cleaningConsoleWindow();
                    new EventsByOrganizer().showByOrganizer();
                    break;

                default:
                    MenuBuilder.nothingHereYetPromptPrinting();
            }
        }
    }





    }



