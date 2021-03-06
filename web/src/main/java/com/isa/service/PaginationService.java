package com.isa.service;

import com.isa.dao.EventDao;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PaginationService {

    @Inject
    EventDao eventDao;

    public int add(int numberOfElementsOnPage) {
        return numberOfElementsOnPage + 20;
    }

    public int reduce(int numberOfElementsOnPage) {
        return numberOfElementsOnPage - 20;
    }

    public int getLastPage() {
        return eventDao.getNumberOfEvents() - 20;
    }
}
