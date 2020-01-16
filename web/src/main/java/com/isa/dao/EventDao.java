package com.isa.dao;

import com.isa.domain.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EventDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewEvent(Event event) {
        em.persist(event);
        logger.info("New event has been added to the DB ");
        return event.getId();
    }

    public List<Event> findAll() {
        List listOfEvents = em
                .createNamedQuery("Event.findAll")
                .getResultList();

        return listOfEvents;
    }

    public Event findById(Long id) {
        return em.find(Event.class, id);
    }

    public Event editEvent(Event event) {
        return em.merge(event);
    }


}
