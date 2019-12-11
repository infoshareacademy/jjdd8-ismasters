package com.infoshareacademy.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingPrinter {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    void printGreeting() {
        stdout.info(MenuBuilder.MENU_TOP_FRAME);
        stdout.info(MenuBuilder.MENU_FRAME);
        stdout.info("│      " + ColorHandler.YELLOW + "Witaj w kalendarzu wydarzeń kulturalnych      " + ColorHandler.DEFAULT + "│\n");
        stdout.info(MenuBuilder.MENU_FRAME);
        stdout.info("│                (c) ISMasters 2019                  │\n");
        stdout.info(MenuBuilder.MENU_FRAME);
        stdout.info(MenuBuilder.MENU_BOTTOM_FRAME);
        stdout.info("\n");
        stdout.info("\n");
    }
}