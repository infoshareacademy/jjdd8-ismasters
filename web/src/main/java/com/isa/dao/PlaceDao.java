package com.isa.dao;

import com.isa.domain.entity.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class PlaceDao {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewPlace(Place place) {
        em.persist(place);
        logger.debug("New event has been added to the DB ");
        return place.getId();
    }

    public List<Place> findAll() {
        List placesList = em
                .createNamedQuery("Place.findAll")
                .getResultList();

        return placesList;
    }

    public Optional<Place> findById(Long id) {
        return Optional.ofNullable(em.find(Place.class, id));
    }

    public Optional<Place> editPlace(Place place) {
        return Optional.ofNullable(em.merge(place));
    }

    public Place findByApiId(Integer apiId) {
        Query query = em.createNamedQuery("Place.findByApiId");
        query.setParameter("apiId", apiId);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            // ignores multiple results
            return (Place) results.get(0);
        }
        return null;
    }


}
