package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuBuilder {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    //kolory
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String PURPLE = "\u001b[35m";
    public static final String WHITE = "\u001b[37m";
    public static final String CYAN = "\u001b[36m";
    public static final String DEFAULT = "\u001b[0m";
    //stała do wyliczania szerokosci drukowanych linii w menu
    static final int LENGTH = 68;
    final static String MENU_TOP_PIPE = "└──────────────────────────────────────────────────────────────────┘\n";
    final static String MENU_BOTTOM_PIPE = "┌──────────────────────────────────────────────────────────────────┐\n";
    private final static String GOOD_BYE = "Do Zobaczenia :D";
    static String displayedOption1;
    static String displayedOption2;
    static String displayedOption3;
    static String GoBack;


    static void buildMenuPrinter(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                 DynamicLinePrinter.printDynamicMenuRows(displayedOption1) +
                 DynamicLinePrinter.printDynamicMenuRows(displayedOption2) +
                 DynamicLinePrinter.printDynamicMenuRows(displayedOption3) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsPurple(GoBack) +
                DynamicLinePrinter.printDynamicMenuRows("Podaj nr pozycji z menu którą wybierasz:") +
                MENU_TOP_PIPE +
                "\n");
    }

    static void goodByeWindowPrinter(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsPurple(GOOD_BYE) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void greetingPrinter(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsYellow("Witaj w kalendarzu wydarzeń kulturalnych") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsCyan("(c) ISMasters 2019") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void promotedOrganizersPrinter(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer1Builder) +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer2Builder) +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer3Builder) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows("Powrót") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void nothingHereYetPromptPrinter(){
        ScreenCleaner.cleanConsole();
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsRed("Pod tym numerem jeszcze nic nie ma :(") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void nearEventPrinter(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.today) +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.tommorow) +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.next3Days) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void wrongInputPromptPrinter(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsRed("PODANO NIEPRAWIDŁOWĄ WARTOŚĆ!") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);

    }
}