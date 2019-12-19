package com.infoshareacademy.menu;

import com.infoshareacademy.domain.parser.Event;
import com.infoshareacademy.repository.EventsRepository;
import com.infoshareacademy.service.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class RemoveEvents {
    private static final Logger stdout = LoggerFactory.getLogger("CONSOLE_OUT");
    Event searchedEvent = new Event();

    public void removeEvent(int Id){
        searchEventAfterId(Id);
        removeEventFromRepository();

        Parser parser = new Parser();
        parser.parseDataToJson();

        findEventWithId(Id);
    }

    public void findEventWithId(int Id){
        for (Event event : EventsRepository.getInstance().getEvents()) {
            if ((event.getid() == Id)){
                stdout.info("\n" + "Wydarzenie nadal znajduje się w zbiorze");
            }
        }
    }
    public void removeEventFromRepository(){

        try {
            int indexEvent = EventsRepository.getInstance().getEvents().indexOf(searchedEvent);

            EventsRepository.getInstance().getEvents().remove(indexEvent);
        }catch (Exception e){
            stdout.info("\n" + "Brak obiektu w zbiorze zostało usunięte");
        }
    }

    public Event searchEventAfterId(int id){

        searchedEvent =  EventsRepository.getInstance().getEvents().stream()
                .filter(e -> e.getid() == id)
                .findAny()
                .orElse(null);

        return searchedEvent;
    }
}
