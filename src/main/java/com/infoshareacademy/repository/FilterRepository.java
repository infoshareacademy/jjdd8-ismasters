package com.infoshareacademy.repository;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.service.parser.Parser;

public class FilterRepository {
    Parser parser = new Parser();

    public void allEvents() {
            parser.parseData();
        for (Event e:EventsRepository.getEvents()) {
            System.out.println(EventsRepository.getEvents().);
        }

    }

  /*  public String filterAllDatesEvents(String date){

    }
    public String filterAllOrganisers (String organiser){

    }
    public String filterAllUpcommingEvents(){

    }*/

    public static void main(String[] args) {
        FilterRepository f1 = new FilterRepository();
        f1.allEvents();
    }

}
