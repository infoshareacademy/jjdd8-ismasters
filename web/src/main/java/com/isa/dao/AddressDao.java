package com.isa.dao;

import com.isa.domain.entity.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Stateless
public class AddressDao {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long add(Address address) {
        em.persist(address);
        logger.debug("New address has been added to the DB, id: {}", address.getId());
        return address.getId();
    }

    public List<Address> findAll() {
        List addressList = em
                .createNamedQuery("Address.findAll")
                .getResultList();

        return addressList;
    }



}
