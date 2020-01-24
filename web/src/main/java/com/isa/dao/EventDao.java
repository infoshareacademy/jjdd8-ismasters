package com.isa.dao;

import com.isa.domain.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
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

    public List<Event> findAllUserFavEvents(Long id) {
        Query q = em.createNamedQuery("SELECT e FROM User u INNER JOIN u.favourtieEvents e WHERE u.id = :id");
        q.setParameter("id", id);
        return q.getResultList();
    }

    public Event getClosestInTimeUserFav(Long id) {
        Query q = em.createNamedQuery("SELECT e FROM User u INNER JOIN u.favouriteEvents e WHERE u.id = :id and e.startDate > :today ORDER BY e.startDate LIMIT 1");
        q.setParameter("id", id);
        String today = LocalDate.now().toString();
        q.setParameter("today", today);
        List<Event> single = q.getResultList();
        Event qwe = single.get(0);
            return qwe;
    }
}

/**
 * zapytanie jpql wyciagajace liste ulubionych z usera sortujace po dacie wyciagajace najblizsze
 * sortowanie na selekcie i limit na jedno
 **/