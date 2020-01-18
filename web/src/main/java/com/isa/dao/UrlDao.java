package com.isa.dao;

import com.isa.domain.entity.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class UrlDao {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewUrl(Url url) {
        em.persist(url);
        logger.info("New url has been added to the DB ");
        return url.getId();
    }

    public List<Url> findAll() {
        List listOfUrl = em
                .createNamedQuery("Url.findAll")
                .getResultList();

        return listOfUrl;
    }

    public Optional<Url> findById(Long id) {
        return Optional.ofNullable(em.find(Url.class, id));
    }

    public Optional<Url> editEvent(Url url) {
        return Optional.ofNullable(em.merge(url));
    }

    public Url findByWww(String www) {
        Query query = em.createNamedQuery("Url.findByWww");
        query.setParameter("www", www);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            // ignores multiple results
            return (Url) results.get(0);
        }
        return null;
    }

}
