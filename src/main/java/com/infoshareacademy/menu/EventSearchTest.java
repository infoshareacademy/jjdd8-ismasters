package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.FilterRepository;
import com.infoshareacademy.service.parser.Parser;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class EventSearchTest {

    public static final Scanner scanner = new Scanner(System.in);

    public static void searchEvents(FilterRepository filterRepository, Predicate<Event> searchCondition) {
        EventsPrinter.printEvents(filterRepository.genericFilter(searchCondition));
    }

    public static void main(String[] args) {
        int mainExitCode = 0;
        String searchString;

        Parser parser = new Parser();
        parser.initialization();

        while (mainExitCode != 9) {

            //TODO sprawdzanie minimum 3 liter w wyszukiwaniu
            System.out.println("1. Wyszukiwanie wg miejsca eventu");
            System.out.println("2. Wyszukiwanie wg organizatora");
            System.out.println("3. Wyszukiwanie wg daty");
            System.out.println();
            System.out.println("9. Wyjście");


            switch (ChoiceGetter.getChoice()) {
                case 1:
                    do {
                        System.out.println("Podaj miejsce do wyszukania i wciśnij ENTER");
                        searchString = scanner.nextLine();
                        if (searchString.length() < 3) {
                            System.out.println("Wpisz co najmniej 3 znaki");
                        }
                    } while (searchString.length() < 3);

                    System.out.println("Szukam: " + searchString);
                    String finalSearchString = searchString;
                    Predicate<Event> searchCondition = event -> event.getPlace().getName().toLowerCase().contains(finalSearchString.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 2:
                    do {
                        System.out.println("Podaj nazwę organizatora do wyszukania i wciśnij ENTER");
                        searchString = scanner.nextLine();
                        if (searchString.length() < 3) {
                            System.out.println("Wpisz co najmniej 3 znaki");
                        }
                    } while (searchString.length() < 3);

                    System.out.println("Szukam: " + searchString);
                    String finalSearchString1 = searchString;
                    searchCondition = event -> event.getOrganizer().getDesignation().toLowerCase().contains(finalSearchString1.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 3:
                    System.out.println("Podaj datę w formacie YYYY-MM-DD do wyszukania i wciśnij ENTER");
                    searchString = scanner.nextLine();
                    if (!Pattern.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$", searchString)) {
                        System.out.println("Zły format daty");
                        break;
                    }
                    if (LocalDate.parse(searchString).isBefore(LocalDate.now())) {
                        System.out.println("Wybierz dzień dzisiejszy lub późniejszą datę!");
                        break;
                    }
                    System.out.println("Szukam: " + searchString);
                    String finalSearchString2 = searchString;
                    searchCondition = event -> event.getStartDate().contains(finalSearchString2.toLowerCase());
                    searchEvents(new FilterRepository(), searchCondition);
                    break;

                case 9:
                    System.out.println("Koniec wyszukiwania");
                    mainExitCode = 9;
                    break;
            }
        }
    }
}
