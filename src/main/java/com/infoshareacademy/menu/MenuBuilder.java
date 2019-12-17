package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MenuBuilder {
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
    static final String MENU_TOP_PIPE = "└──────────────────────────────────────────────────────────────────┘\n";
    static final String MENU_BOTTOM_PIPE = "┌──────────────────────────────────────────────────────────────────┐\n";
    private static final String GOOD_BYE = "Do Zobaczenia :D";


    static void printMenuBuilder(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                 DynamicLinePrinter.printDynamicMenuRows(Menu.MAIN_MENU_OPTION1) +
                 DynamicLinePrinter.printDynamicMenuRows(Menu.MAIN_MENU_OPTION2) +
                 DynamicLinePrinter.printDynamicMenuRows(Menu.MAIN_MENU_OPTION3) +
                 DynamicLinePrinter.printDynamicMenuRows(Menu.MAIN_MENU_OPTION4) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsPurple(Menu.MAIN_MENU_EXIT) +
                DynamicLinePrinter.printDynamicMenuRows("Podaj nr pozycji z menu którą wybierasz:") +
                MENU_TOP_PIPE +
                "\n");
    }

    static void printGoodByeWindow(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsPurple(GOOD_BYE) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void printGreeting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsYellow("Witaj w kalendarzu wydarzeń kulturalnych") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsCyan("(c) ISMasters 2019") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void printPromotedOrganizers(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer1Builder) +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer2Builder) +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer3Builder) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(EventsByOrganizer.promotedOrganizer9Builder) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void printNumberInactiveInfo(){
        ScreenCleaner.cleanConsoleWindow();
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsRed("Pod tym numerem jeszcze nic nie ma :(") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void printNearEvent(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.today) +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.tommorow) +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.next3Days) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(NearestEvents.exit) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void printWrongInputPrompt(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRowsRed("PODANO NIEPRAWIDŁOWĄ WARTOŚĆ!") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);

    }

    static void printGeneralEventSearch(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(EventSearch.SEARCH_MENU_OPTION1) +
                DynamicLinePrinter.printDynamicMenuRows(EventSearch.SEARCH_MENU_OPTION2) +
                DynamicLinePrinter.printDynamicMenuRows(EventSearch.SEARCH_MENU_OPTION3) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicMenuRows(EventSearch.SEARCH_MENU_EXIT) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }
}