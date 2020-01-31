package com.isa.mapper;

import com.isa.domain.api.WeblinkApi;
import com.isa.domain.dto.UrlDto;
import com.isa.domain.entity.Url;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class UrlMapper {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Url mapApiViewToEntity(WeblinkApi weblinkApi) {
        logger.debug("Url mapping to Entity");

        Url url = new Url();

        url.setWwwUrl(weblinkApi.getWebsite());
        url.setFbUrl(weblinkApi.getFb());
        url.setTickerUrl(weblinkApi.getTickets());

        logger.debug("Url mapping to Entity-> all parameters set Url {}", url.getWwwUrl());

        return url;
    }

    public UrlDto mapApiViewToDto(Url url) {
        logger.debug("Url mapping to DTO");

        UrlDto urlDto = new UrlDto();

        urlDto.setWebsite(url.getWwwUrl());
        urlDto.setFbLink(url.getFbUrl());
        urlDto.setTicketLink(url.getTickerUrl());

        logger.debug("Url mapping to DTO-> all parameters set Url {}", urlDto.getWebsite());

        return urlDto;
    }

}
