package com.isa.service.manager;

import com.isa.dao.UrlDao;
import com.isa.domain.api.EventApi;
import com.isa.domain.entity.Url;
import com.isa.parser.ApiDataParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@Stateless
public class UrlManager {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());


    @Inject
    private UrlDao urlDao;

    @Inject
    private ApiDataParser apiDataParser;

    public void setRelationsUrl(String jsonString) throws IOException {
        List<EventApi> list = apiDataParser.parse(jsonString, EventApi.class);
        logger.debug("Weblinki listę Wydarzeń");
        for (EventApi e: list) {
            Url url = new Url();

            url.setTickerUrl(e.getWeblinkExternal().getTickets());
            url.setFbUrl(e.getWeblinkExternal().getFb());
            url.setWwwUrl(e.getWeblinkExternal().getWebsite());
            urlDao.addNewUrl(url);

            logger.debug("Wydarzenia mapowane i kierowane do bazy danych");

        }
    }
}
