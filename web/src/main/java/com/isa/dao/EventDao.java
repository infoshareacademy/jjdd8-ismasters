package com.isa.dao;

import com.isa.domain.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Stateless
public class EventDao {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    private int MAX_RESULT_ON_PAGE = 15;
    private int MAX_RESULT_ON_PAGE_API = 5;
    @PersistenceContext
    private EntityManager em;

    public long add(Event event) {
        em.persist(event);
      logger.debug("New event has been added to the DB ");
        return event.getId();
    }

    public long addFromFile(Event event) {
        logger.debug("New event has been added to the DB ");
        return em.merge(event).getId();
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

    public List<Event> getEventsForView(int startEvent, int maxPage) {
        Query query = em.createNamedQuery("Event.findAll");
        query.setFirstResult(startEvent);
        query.setMaxResults(maxPage);
        return query.getResultList();
    }

    public int getNumberOfEvents() {
        return ((Number) em.createNamedQuery("Event.countAll").getSingleResult()).intValue();
    }

    public List<Event> findByName(String param) {
        Query query = em.createNamedQuery("Event.findByName");
        query.setParameter("param", "%" + param + "%");


        return query.setMaxResults(MAX_RESULT_ON_PAGE).getResultList();
    }

    public List<Event> findByNameRest(String param, LocalDateTime startDate, LocalDateTime endDate) {
        Query query = em.createNamedQuery("Event.findByName");

        query.setParameter("param", param);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);

        return query.setMaxResults(MAX_RESULT_ON_PAGE_API).getResultList();
    }

    public List<Event> findByOrganizersId(int id) {
        Query query = em.createNamedQuery("Event.findByOrganizersId");

        query.setParameter("organizerId", id);
        logger.info("DAO event list size {}", query.getResultList().size());
        return query.setMaxResults(MAX_RESULT_ON_PAGE).getResultList();
    }

    public List<Event> findByOrganizersIdPaged(int id, int startEvent, int maxPage) {
        Query query = em.createNamedQuery("Event.findByOrganizersId");
        query.setParameter("organizerId", id);
        query.setFirstResult(startEvent);
        query.setMaxResults(maxPage);
        return query.getResultList();
    }
    public List<Event> getFavEventsList(long userId) {
        Query query = em.createNamedQuery("Event.findAllForUser");
        query.setParameter("id",userId);
        return query.getResultList();
    }

    public List<Event> getAllFavEventsList() {
        Query query = em.createNamedQuery("Event.findAllFavorites");
        return query.getResultList();
    }

    public void deleteEvent(Long id) {
        final Event e = em.find(Event.class, id);
        if (e != null) {
            em.remove(e);
        }
    }
}
