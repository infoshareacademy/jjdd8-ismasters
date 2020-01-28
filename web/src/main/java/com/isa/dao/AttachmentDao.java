package com.isa.dao;

import com.isa.domain.entity.Address;
import com.isa.domain.entity.Attachments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Stateless
public class AttachmentDao {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager em;

    public long addNewAttachment(Attachments attachments) {
        em.persist(attachments);
        logger.debug("New attachment has been added to the DB, id: {}", attachments.getId());
        return attachments.getId();
    }

    public List<Attachments> findAll() {
        List AttachmentsList = em
                .createNamedQuery("Attachments.findAll")
                .getResultList();

        return AttachmentsList;
    }

    public Optional<Attachments> findById(Long id) {
        return Optional.ofNullable(em.find(Attachments.class, id));
    }

    public Optional<Attachments> editAddress(Attachments attachments) {
        return Optional.ofNullable(em.merge(attachments));
    }


}
