package com.isa.dao;

import com.isa.domain.entity.Organizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class OrganizersDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewOrganizer(Organizer organizer) {
        em.persist(organizer);
        logger.info("New organizer has been added to the DB ");
        return organizer.getId();
    }

    public List<Organizer> findAll() {
        List listOfEvents = em
                .createNamedQuery("Organizer.findAll")
                .getResultList();

        return listOfEvents;
    }

    public Organizer findById(Long id) {
        return em.find(Organizer.class, id);
    }

    public Organizer editEvent(Organizer organizer) {
        return em.merge(organizer);
    }

    public Organizer findByApiId(Long apiId) {
        Query query = em.createQuery("SELECT o FROM Organizer o WHERE o.apiId=:apiId");
        query.setParameter("apiId", apiId);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            // ignores multiple results
            return (Organizer) results.get(0);
        }
        return null;
    }

}
