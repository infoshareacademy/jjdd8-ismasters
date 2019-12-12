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
                 DynamicLinePrinter.printDynamicMenu(Option1) +
                 DynamicLinePrinter.printDynamicMenu(Option2) +
                 DynamicLinePrinter.printDynamicMenu(Option3) +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                ColorHandler.PURPLE + DynamicLinePrinter.printDynamicMenu(GoBack) + ColorHandler.DEFAULT +
                DynamicLinePrinter.printDynamicMenu("Podaj nr pozycji z menu którą wybierasz:") +
                MENU_BOTTOM_WIDER_FRAME +
                "\n");
    }

    static void goodByeWindow(){
        stdout.info(MENU_TOP_WIDER_FRAME +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                ColorHandler.PURPLE + DynamicLinePrinter.printDynamicMenu(GOOD_BYE) + ColorHandler.DEFAULT +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_BOTTOM_WIDER_FRAME);
    }

    static void greetingPrint(){
        stdout.info(MENU_TOP_WIDER_FRAME +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                ColorHandler.YELLOW + DynamicLinePrinter.printDynamicMenu("Witaj w kalendarzu wydarzeń kulturalnych") + ColorHandler.DEFAULT +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                ColorHandler.CYAN + DynamicLinePrinter.printDynamicMenu("(c) ISMasters 2019") + ColorHandler.DEFAULT +
                new EmptyLineWithPipesPrinter().printEmptyLineWithPipe() +
                MENU_BOTTOM_WIDER_FRAME);
    }
}