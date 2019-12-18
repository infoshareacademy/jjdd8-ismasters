package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.service.parser.Parser;



public class App {
    public static final String JSON_REPOSITORY = "JSON_example";

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.initialization(JSON_REPOSITORY);

        Menu.mainMenu();
        Menu.mainMenu();

    }
}




