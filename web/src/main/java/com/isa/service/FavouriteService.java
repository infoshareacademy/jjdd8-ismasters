package com.isa.service;

import com.isa.domain.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class FavouriteService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public List<Event> findAllFavOfUser(Long id) {
        logger.info("find all user favourites");

    }
}
