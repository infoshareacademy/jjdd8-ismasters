package com.isa.mapper;

import com.isa.domain.dto.UrlDto;
import com.isa.domain.entity.Url;
import com.isa.domain.api.WeblinkExternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class UrlMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Url mapApiViewToEntity(WeblinkExternal weblinkExternal) {
        logger.info("Url mapping to Entity");

        Url url = new Url();

        url.setWwwUrl(weblinkExternal.getWebsite());
        url.setFbUrl(weblinkExternal.getFb());
        url.setTickerUrl(weblinkExternal.getTickets());

        logger.info("Url mapping to Entity-> all parameters set");

        return url;
    }

    public UrlDto mapApiViewToDto(Url url) {
        logger.info("Url mapping to DTO");

        UrlDto urlDto = new UrlDto();

        urlDto.setWebsite(url.getWwwUrl());
        urlDto.setFbLink(url.getFbUrl());
        urlDto.setTicketLink(url.getTickerUrl());

        logger.info("Url mapping to DTO-> all parameters set");

        return urlDto;
    }

}
