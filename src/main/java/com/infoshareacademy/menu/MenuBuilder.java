package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuBuilder {
    //kolory
    //RED = "\u001b[31m"
    //GREEN = "\u001b[32m";
    //YELLOW = "\u001b[33m";
    //PURPLE = "\u001b[35m";
    //CYAN = "\u001b[36m";
    //WHITE = "\u001b[37m";
    //DEFAULT = "\u001b[0m";
    public static final String CYAN = "\u001b[36m";
    public static final String DEFAULT = "\u001b[0m";
    static int length = 68;
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    final static String MENU_TOP_PIPE = "└──────────────────────────────────────────────────────────────────┘\n";
    final static String MENU_BOTTOM_PIPE = "┌──────────────────────────────────────────────────────────────────┐\n";
    private final static String GOOD_BYE = "Do Zobaczenia :D";
    static String Option1;
    static String Option2;
    static String Option3;
    static String GoBack;


    static void menuBuild(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                 DynamicLinePrinter.printDynamic(Option1) +
                 DynamicLinePrinter.printDynamic(Option2) +
                 DynamicLinePrinter.printDynamic(Option3) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicPurple(GoBack) +
                DynamicLinePrinter.printDynamic("Podaj nr pozycji z menu którą wybierasz:") +
                MENU_TOP_PIPE +
                "\n");
    }

    static void goodByeWindow(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicPurple(GOOD_BYE) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void greetingPrint(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicYellow("Witaj w kalendarzu wydarzeń kulturalnych") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicCyan("(c) ISMasters 2019") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void promotedOrganizers(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamic(EventsByOrganizer.promotedOrganizer1Builder) +
                DynamicLinePrinter.printDynamic(EventsByOrganizer.promotedOrganizer2Builder) +
                DynamicLinePrinter.printDynamic(EventsByOrganizer.promotedOrganizer3Builder) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamic("Powrót") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void nothingHereYetPrompt(){
        ScreenCleaner.cleanConsole();
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicRed("Pod tym numerem jeszcze nic nie ma :(") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void nearEvent(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamic(NearestEvents.today) +
                DynamicLinePrinter.printDynamic(NearestEvents.tommorow) +
                DynamicLinePrinter.printDynamic(NearestEvents.next3Days) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);
    }

    static void wrongInputPrompt(){
        stdout.info(MENU_BOTTOM_PIPE +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicRed("PODANO NIEPRAWIDŁOWĄ WARTOŚĆ!") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_TOP_PIPE);

    }
}