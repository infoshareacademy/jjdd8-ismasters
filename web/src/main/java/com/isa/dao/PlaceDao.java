package com.isa.dao;

import com.isa.domain.entity.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PlaceDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewEvent(Place place) {
        em.persist(place);
        logger.info("New event has been added to the DB ");
        return place.getId();
    }

    public List<Place> findAll() {
        List placesList = em
                .createNamedQuery("Place.findAll")
                .getResultList();

        return placesList;
    }

    public Place findById(Long id) {
        return em.find(Place.class, id);
    }

    public Place editEvent(Place place) {
        return em.merge(place);
    }

    public Place findByApiId(Integer apiId) {
        Query query = em.createQuery("SELECT p FROM Place p WHERE p.apiId=:apiId");
        query.setParameter("apiId", apiId);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            // ignores multiple results
            return (Place) results.get(0);
        }
        return null;
    }


}
