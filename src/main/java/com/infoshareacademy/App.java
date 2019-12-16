package com.infoshareacademy;

import com.infoshareacademy.filter.Filtering;
import com.infoshareacademy.repository.FilterRepository;
import com.infoshareacademy.service.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.initialization();


        /*List<String> l1 = new ArrayList<>();
        l1 = f1.giveDays("2019-12-07", "2019-12-10");*/
 /*       System.out.println();
        f1.giveFilteredEvents(l1);*/


        /*Filtering f1 = new Filtering();
        System.out.println(f1.giveFilteredEvents("2019-12-07", "2019-12-10", f1.getAllOrganizers()));
        // Menu.mainMenu();*/
    }
}




