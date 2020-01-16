package com.isa.mapper;

import com.isa.domain.entity.Url;
import com.isa.domain.api.WeblinkApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class UrlMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public Url mapApiViewToEntity(WeblinkApi weblinkApi) {
        logger.info("Url mapping to Entity");

        Url url = new Url();

        url.setWwwUrl(weblinkApi.getWebsite());
        url.setFbUrl(weblinkApi.getFb());
        url.setTickerUrl(weblinkApi.getTickets());

        logger.info("Url mapping to Entity-> all parameters set");

        return url;
    }

}
