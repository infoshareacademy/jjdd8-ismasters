package com.infoshareacademy.menu;

import com.infoshareacademy.menu.ColorHandler;
import com.infoshareacademy.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuBuilder {
    static int length = 61;
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
    private final static String GOOD_BYE = ColorHandler.PURPLE + "Do Zobaczenia :D" + ColorHandler.DEFAULT;
    private final static String FIXED_GOOD_BYE = String.format("%1$"+length+"s", GOOD_BYE);

    static void menuBuild(){
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n" +
                "│                                                                  │\n" +
                "│                                                                  │\n" +
                "|   " + Menu.FIXED_MENU_OPTION1 + "  |\n" +
                "|   " + Menu.FIXED_MENU_OPTION2 + "  |\n" +
                "|   " + Menu.FIXED_MENU_OPTION3 + "  |\n" +
                "│                                                                  │\n" +
                "│                                                                  │\n" +
                "│                          Wpisane 9 powoduje wyjscie z programu   │\n" +
                "│                        Podaj nr pozycji z menu którą wybierasz:  │\n" +
                "└──────────────────────────────────────────────────────────────────┘\n" +
                "\n");
    }

    static void goodByeWindow(){
        stdout.info("┌──────────────────────────────────────────────────────────────────┐\n" +
                "│                                                                  │\n" +
                "|  " + FIXED_GOOD_BYE + "  |\n" +
                "│                                                                  │\n" +
                "└──────────────────────────────────────────────────────────────────┘\n");
    }
}