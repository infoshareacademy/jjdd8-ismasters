package com.isa.dao;

import com.isa.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Stateless
public class UserDao {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    EntityManager em;

    public List<User> findAll() {
        Query q = em.createNamedQuery("SELECT u FROM User u");
        return q.getResultList();
    }

    public void saveUser(User user) {
        log.info("User id: {} has been added to DB");
        em.persist(user);
    }

    public User findById(Long id) throws Throwable {
        try {
            log.info("User id: {} has been found");
            return em.find(User.class, id);
        } catch (Throwable t) {
            log.error("user not found" + t);
            throw t;
        }
    }


}
