package com.isa.dao;

import com.isa.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class UserDao {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @PersistenceContext
  EntityManager entityManager;

  public List<User> findAll() {
    Query query = entityManager.createNamedQuery("User.findAll", User.class);
    return query.getResultList();
  }

  public void add(User user) {
    logger.info("Object user id: {} persist to DB", user.getId());
    entityManager.persist(user);
  }

  public void update(User user) {
    entityManager.merge(user);
  }

  public User findById(Long id) {
    logger.info("Object event id: {} has been found", id);
    return entityManager.find(User.class, id);
  }

  public Optional<User> findByEmail(String email) {

    Query query = entityManager.createNamedQuery("User.findByEmail");
    query.setParameter("email", email);
    List<User> users = query.getResultList();
    logger.info("Object User: {} has been found", email);
    if (users.isEmpty()) {
      logger.warn("User for email {} not found", email);
      return Optional.empty();
    }
    return Optional.of(users.get(0));
  }
}
