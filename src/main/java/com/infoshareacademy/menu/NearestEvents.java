package com.infoshareacademy.menu;

import com.infoshareacademy.repository.FilterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static com.infoshareacademy.menu.EventsPrinter.printEvents;

public class NearestEvents {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    static String today = "1. Pokaż dzisiejsze wydarzenia";
    static String tommorow = "2. Pokaż jutrzejsze wydarzenia";
    static String next3Days = "3. Pokaż wydarzenia za 3 dni";
    static String exit = "9. Wyjdź go poprzedniego menu";

    void showNearestEvents() {
        FilterRepository filterRepository = new FilterRepository();

        int returnCheckInt = 0;

        while (returnCheckInt != 9) {

            MenuBuilder.printNearEvent();

            switch (ChoiceGetter.getChoice()) {
                case 1:

                    printEvents(filterRepository.filterAllDatesEvents(LocalDate.now().toString()));
                    break;
                case 2:

                    printEvents(filterRepository.filterAllDatesEvents(LocalDate.now().plusDays(1).toString()));
                    break;
                case 3:

                    printEvents(filterRepository.filterAllDatesEvents(LocalDate.now().plusDays(2).toString()));
                    break;
                case 9:
                    ScreenCleaner.cleanConsoleWindow();
                    stdout.info("        POWRÓT DO POPRZEDNIEGO MENU       \n");
                    returnCheckInt = 9;
                    break;
                case 0:
                    break;
                default:
                    MenuBuilder.printNumberInactiveInfo();
            }
        }
    }
}