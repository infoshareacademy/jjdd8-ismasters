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
        logger.info("New event has been added to the DB ");
        return event.getId();
    }

    public List<Event> findAll() {
        return em.createNamedQuery("Event.findAll").getResultList();
    }

    public Optional<Event> findById(Long id) {
        return Optional.ofNullable(em.find(Event.class, id));
    }

    public List<Event> searchByName(String search) {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.name LIKE :search");
        q.setParameter("search", "%" + search + "%");
        return q.getResultList();
    }

    public Optional<Event> editEvent(Event event) {
        return Optional.ofNullable(em.merge(event));
    }
}