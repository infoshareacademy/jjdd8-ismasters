package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.service.parser.Parser;

public class App {

    public static void main(String[] args) {
        final String JSON = "JSON_example";
        Parser parser = new Parser();
        parser.initialization(JSON);
        Menu.mainMenu();
    }
}