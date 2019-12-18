package com.infoshareacademy;

import com.infoshareacademy.menu.Menu;
import com.infoshareacademy.service.parser.Parser;



public class App {

    public static void main(String[] args) {
        final String JSON = "JSON_example";
        Parser parser = new Parser();
        parser.initialization(JSON);


       /* List<String> l1 = new ArrayList<>();
        l1 = f1.giveDays("2019-12-07", "2019-12-10");
        System.out.println();
        f1.giveFilteredEvents(l1);*/
        /*List<String> lista = List.of("Sopot");

        Filtering f1 = new Filtering();
        System.out.println(f1.giveFilteredEvents("2019-12-10", "2019-12-31", lista));*/
       /*new AddingNewEvent().addNewEvent();*/
       // new EventsByOrganizer().showAllOrganizers();
       //parser.parseDataToJson(JSON,);
         Menu.mainMenu();


       Menu.mainMenu();

    }
}




