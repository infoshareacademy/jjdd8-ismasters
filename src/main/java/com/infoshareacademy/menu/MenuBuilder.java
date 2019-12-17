package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.infoshareacademy.menu.ManagingEvents.*;

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
    static String displayedOption4;
    static String GoBack;


    static void menuBuilderPrinting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                 DynamicLinePrinter.printingDynamicMenuRows(displayedOption1) +
                 DynamicLinePrinter.printingDynamicMenuRows(displayedOption2) +
                 DynamicLinePrinter.printingDynamicMenuRows(displayedOption3) +
                 DynamicLinePrinter.printingDynamicMenuRows(displayedOption4)+
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRowsPurple(GoBack) +
                DynamicLinePrinter.printingDynamicMenuRows("Podaj nr pozycji z menu którą wybierasz:") +
                MENU_TOP_PIPE +
                "\n");
    }

    static void goodByeWindowPrinting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRowsPurple(GOOD_BYE) +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void greetPrinting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRowsYellow("Witaj w kalendarzu wydarzeń kulturalnych") +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRowsCyan("(c) ISMasters 2019") +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void promotedOrganizersPrinting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRows(EventsByOrganizer.promotedOrganizer1Builder) +
                DynamicLinePrinter.printingDynamicMenuRows(EventsByOrganizer.promotedOrganizer2Builder) +
                DynamicLinePrinter.printingDynamicMenuRows(EventsByOrganizer.promotedOrganizer3Builder) +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRows("Powrót") +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void nothingHereYetPromptPrinting(){
        ScreenCleaner.cleaningConsoleWindow();
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRowsRed("Pod tym numerem jeszcze nic nie ma :(") +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void nearEventPrinting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRows(NearestEvents.today) +
                DynamicLinePrinter.printingDynamicMenuRows(NearestEvents.tommorow) +
                DynamicLinePrinter.printingDynamicMenuRows(NearestEvents.next3Days) +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void wrongInputPromptPrinting(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRowsRed("PODANO NIEPRAWIDŁOWĄ WARTOŚĆ!") +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);

    }
    static void managingEvents(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                DynamicLinePrinter.printingDynamicMenuRows(addingNewEvent) +
                DynamicLinePrinter.printingDynamicMenuRows(editingAnEvent) +
                DynamicLinePrinter.printingDynamicMenuRows(deletingAnEvent) +
                DynamicLinePrinter.printingDynamicMenuRows(addingToFavorite) +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printingEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }
}