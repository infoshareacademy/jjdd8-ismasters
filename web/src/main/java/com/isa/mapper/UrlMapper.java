package com.isa.mapper;

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

}
