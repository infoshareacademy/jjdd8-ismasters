package com.isa.service.constant;

import com.isa.dao.EventDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


@RequestScoped
public class PageEventSize {

    @Inject
    EventDao eventDao;


    public void validate(int setStartEvent, int pageSize){


        //int maxPages = Math.ceil((eventDao.getNumberOfEvents())/pageSize);


    }





}