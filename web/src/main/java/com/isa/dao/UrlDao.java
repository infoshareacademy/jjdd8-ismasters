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

    public long add(Url url) {
        em.persist(url);
        logger.debug("New url has been added to the DB ");
        return url.getId();
    }

    public List<Url> findAll() {
        List listOfUrl = em
                .createNamedQuery("Url.findAll")
                .getResultList();

        return listOfUrl;
    }


}
