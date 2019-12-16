package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.service.parser.Parser;

public class App {

    public static void main(String[] args) {
        String json = "JSON_example";
        Parser parser = new Parser();
        parser.initialization(json);
        Menu.mainMenu();
    }
}