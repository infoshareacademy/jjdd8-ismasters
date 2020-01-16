package com.isa.dao;

import com.isa.domain.entity.Event;
import com.isa.domain.entity.Place;
import com.isa.domain.entity.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UrlDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewUrl(Url url){
        em.persist(url);
        logger.info("New url has been added to the DB ");
        return url.getId();
    }

    public List<Url> findAll(){
        List listOfUrl = em
                .createNamedQuery("Url.findAll")
                .getResultList();

        return listOfUrl;
    }

    public Url findById(Long id){
        return em.find(Url.class, id);
    }

    public Url editEvent(Url url){
        return em.merge(url);
    }

    public Url findByWWW(String www){
        Query query = em.createQuery("SELECT u FROM Url u WHERE u.wwwUrl = :www");
        query.setParameter("www",www);
        List results = query.getResultList();
        if(!results.isEmpty()){
            // ignores multiple results
            return (Url) results.get(0);
        }
        return null;
    }

}
