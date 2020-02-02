package com.isa.dao;

import com.isa.domain.entity.Organizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class OrganizersDao {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long add(Organizer organizer) {
        em.persist(organizer);
        logger.debug("New organizer has been added to the DB ");
        return organizer.getId();
    }

    public long addFromFile(Organizer organizer) {
        logger.debug("New organizer has been added to the DB ");
        return em.merge(organizer).getId();
    }

    public List<Organizer> findAll() {
        List listOfEvents = em
                .createNamedQuery("Organizer.findAll")
                .getResultList();

        return listOfEvents;
    }


    public Organizer findByApiId(Long apiId) {
        Query query = em.createNamedQuery("Organizer.findByApiId");
        query.setParameter("apiId", apiId);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            // ignores multiple results
            return (Organizer) results.get(0);
        }
        return null;
    }

}
