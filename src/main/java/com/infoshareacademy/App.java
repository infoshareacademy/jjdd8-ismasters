package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.service.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.parseData();
        Menu.mainMenu();
    }
}