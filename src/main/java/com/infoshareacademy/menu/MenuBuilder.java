package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuBuilder {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    final static String MENU_WIDER_FRAME = "│                                                                  │\n";
    final static String MENU_BOTTOM_WIDER_FRAME = "└──────────────────────────────────────────────────────────────────┘\n";
    final static String MENU_TOP_WIDER_FRAME = "┌──────────────────────────────────────────────────────────────────┐\n";
    final static String MENU_TOP_FRAME = "┌────────────────────────────────────────────────────┐\n";
    final static String MENU_FRAME = "│                                                    │\n";
    final static String MENU_BOTTOM_FRAME = "└────────────────────────────────────────────────────┘\n";
    final static String WRONG_INPUT_FRAME = "│                                          │\n";
    final static String WRONG_INPUT_TOP ="┌──────────────────────────────────────────┐\n";
    final static String WRONG_INPUT_BOTTOM ="└──────────────────────────────────────────┘\n";

    static void menuBuild(){
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n" +
                "│                                                                  │\n" +
                "│                                                                  │\n" +
                "|   " + Menu.FIXED_MAIN_MENU_OPTION1 + "  |\n" +
                "|   " + Menu.MAIN_MENU_OPTION2 + "  |\n" +
                "|   " + Menu.MAIN_MENU_OPTION3 + "  |\n" +
                "│                                                                  │\n" +
                "│                                                                  │\n" +
                "└──────────────────────────────────────────────────────────────────┘");
    }
}