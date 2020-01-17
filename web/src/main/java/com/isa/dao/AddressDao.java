package com.isa.dao;

import com.isa.domain.entity.Address;
import com.isa.domain.entity.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class AddressDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewAddress(Address address) {
        em.persist(address);
        logger.info("New address has been added to the DB ");
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

    public Address editAddress(Address address) {
        return em.merge(address);
    }

    public Address findByStreet(String street) {
        Query query = em.createQuery("SELECT a FROM Address a WHERE a.street=:street");
        query.setParameter("street", street);
        List results = query.getResultList();
        if (!results.isEmpty()) {
            // ignores multiple results
            return (Address) results.get(0);
        }
        return null;
    }

}
