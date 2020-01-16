package com.isa.dao;

import com.isa.domain.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AddressDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewEvent(Address address) {
        em.persist(address);
        logger.info("New event has been added to the DB ");
        return address.getId();
    }

    public List<Address> findAll() {
        List addressList = em
                .createNamedQuery("Address.findAll")
                .getResultList();

        return addressList;
    }

    public Address findById(Long id) {
        return em.find(Address.class, id);
    }

    public Address editEvent(Address address) {
        return em.merge(address);
    }
}
