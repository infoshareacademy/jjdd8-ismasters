package com.isa.mapper;

import com.isa.dao.AttachmentDao;
import com.isa.domain.api.AttachmentApi;
import com.isa.domain.dto.AttachmentDto;
import com.isa.domain.entity.Attachments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Stateless
public class AttachmentMapper {

    String PICTURE_PROPERTIES = "settings";

    @Inject
    private AttachmentDao attachmentDao;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());


    public AttachmentDto mapAttachmentToDto(List<Attachments> attachmentsList) {

        Properties settings = new Properties();
        try {
            settings.load(Thread.currentThread().getContextClassLoader().getResource(PICTURE_PROPERTIES).openStream());
        } catch (IOException e) {
           logger.error("failed to load : {}", e.getMessage());
        }

        String plug = settings.getProperty("plug_path");

        AttachmentDto attachmentDto = new AttachmentDto();
        if (attachmentsList.size() > 0) {
            attachmentDto.setFileName(attachmentsList.get(0).getFileName());
            return attachmentDto;
        } else {
            attachmentDto.setFileName(plug);
            return attachmentDto;
        }
    }

    public List<Attachments> mapApiToEntity(List<AttachmentApi> attachmentApiList) {
        logger.debug("Map attachmentApi to entity");
        List<Attachments> attachmentsList = new ArrayList<>();
        attachmentApiList.forEach(singleAttachment -> {
                    Attachments attachments = new Attachments();
                    attachments.setFileName(singleAttachment.getFileName());
                    attachmentDao.add(attachments);
                    attachmentsList.add(attachments);
                }
        );
        return attachmentsList;
    }
}
