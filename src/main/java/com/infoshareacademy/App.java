package com.infoshareacademy;

import com.infoshareacademy.menu.AddNewEvents;
import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.menu.RemoveEvents;
import com.infoshareacademy.service.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class App {
    public static final String JSON_REPOSITORY = "JSON_example";

    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");

    private static final String FAVORITES_CSV_FILE_PATH = "./favorites.csv";


    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.initialization(JSON_REPOSITORY);

        //Menu.mainMenu();
        //AddNewEvents addNewEvents = new AddNewEvents();
        //addNewEvents.addNewEvent();
        RemoveEvents removeEvents = new RemoveEvents();
        removeEvents.removeEvent(70023);
    }
}




