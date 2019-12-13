package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuBuilder {
    static int length = 68;
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    final static String MENU_BOTTOM_WIDER_FRAME = "└──────────────────────────────────────────────────────────────────┘\n";
    final static String MENU_WIDER_FRAME = "│                                                                  │\n";
    final static String MENU_TOP_WIDER_FRAME = "┌──────────────────────────────────────────────────────────────────┐\n";
    final static String MENU_TOP_FRAME = "┌────────────────────────────────────────────────────┐\n";
    final static String MENU_FRAME = "│                                                    │\n";
    final static String MENU_BOTTOM_FRAME = "└────────────────────────────────────────────────────┘\n";
    final static String WRONG_INPUT_FRAME = "│                                          │\n";
    final static String WRONG_INPUT_TOP ="┌──────────────────────────────────────────┐\n";
    final static String WRONG_INPUT_BOTTOM ="└──────────────────────────────────────────┘\n";
    private final static String GOOD_BYE = "Do Zobaczenia :D";
    static String Option1;
    static String Option2;
    static String Option3;
    static String GoBack;


    static void menuBuild(){
        stdout.info(MENU_TOP_WIDER_FRAME +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                 DynamicLinePrinter.printDynamic(Option1) +
                 DynamicLinePrinter.printDynamic(Option2) +
                 DynamicLinePrinter.printDynamic(Option3) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicPurple(GoBack) +
                DynamicLinePrinter.printDynamic("Podaj nr pozycji z menu którą wybierasz:") +
                MENU_BOTTOM_WIDER_FRAME +
                "\n");
    }

    static void goodByeWindow(){
        stdout.info(MENU_TOP_WIDER_FRAME +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicPurple(GOOD_BYE) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_BOTTOM_WIDER_FRAME);
    }

    static void greetingPrint(){
        stdout.info(MENU_TOP_WIDER_FRAME +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicYellow("Witaj w kalendarzu wydarzeń kulturalnych") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamicCyan("(c) ISMasters 2019") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_BOTTOM_WIDER_FRAME);
    }

    static void promotedOrganizers(){
        stdout.info(MENU_TOP_WIDER_FRAME +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamic(EventsByOrganizer.promotedOrganizer1Builder) +
                DynamicLinePrinter.printDynamic(EventsByOrganizer.promotedOrganizer2Builder) +
                DynamicLinePrinter.printDynamic(EventsByOrganizer.promotedOrganizer3Builder) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                DynamicLinePrinter.printDynamic("Powrót") +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_BOTTOM_WIDER_FRAME);
    }
}