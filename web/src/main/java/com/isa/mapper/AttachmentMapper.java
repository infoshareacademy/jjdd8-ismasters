package com.isa.mapper;

import com.isa.dao.AttachmentDao;
import com.isa.domain.api.AttachmentApi;
import com.isa.domain.dto.AttachmentDto;

import com.isa.domain.entity.Attachments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Stateless
public class AttachmentMapper {

    @Inject
    private AttachmentDao attachmentDao;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());


    public AttachmentDto mapAttachmentToDto(List<Attachments> attachmentsList) {
        AttachmentDto attachmentDto = new AttachmentDto();

        if (attachmentsList.size()>0){
            attachmentDto.setFileName(attachmentsList.get(0).getFileName());
            return attachmentDto;
        }
        else
        {
            attachmentDto.setFileName("/img/plug");
            return attachmentDto;

        }

    }



    public List<Attachments> mapApiToEntity(List<AttachmentApi> attachmentApiList){
        logger.info("Map attachmentApi to entity");
        List<Attachments> attachmentsList = new ArrayList<>();
        attachmentApiList.forEach(a->{
            Attachments attachments = new Attachments();
            attachments.setFileName(a.getFileName());
            attachmentDao.addNewAttachment(attachments);
            attachmentsList.add(attachments);

                }

        );
        return attachmentsList;
    }
    }
