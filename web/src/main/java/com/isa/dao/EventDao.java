package com.isa.dao;

import com.isa.domain.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class EventDao {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewEvent(Event event) {
        em.persist(event);
        logger.debug("New event has been added to the DB ");
        return event.getId();
    }

    public List<Event> findAll() {
        return em.createNamedQuery("Event.findAll").getResultList();
    }

    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(em.find(Event.class, id));
    }

    public Optional<Event> searchEvents(String search) {
        return Optional.ofNullable(em.find(Event.class, search));
    }

    public Optional<Event> editEvent(Event event) {
        return Optional.ofNullable(em.merge(event));
    }

    public List<Event> getEventsForView(int startEvent, int maxPage){
        Query query = em.createNamedQuery("Event.findAll");
        query.setFirstResult(startEvent);
        query.setMaxResults(maxPage);
        return query.getResultList();
    }

    public int getNumberOfEvents(){
        return ((Number) em.createNamedQuery("Event.countAll").getSingleResult()).intValue();
    }

    public List<Event> findByName(String param) {
        Query query = em.createNamedQuery("Event.findByName");
        query.setParameter("param", "%" + param + "%");
        return query.setMaxResults(5).getResultList();
    }
}
