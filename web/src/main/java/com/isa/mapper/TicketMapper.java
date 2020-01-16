package com.isa.mapper;

import com.isa.domain.entity.TicketType;
import com.isa.domain.api.TicketApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class TicketMapper {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public TicketType mapApiViewToEntity(TicketApi ticketApi) {
        logger.info("TicketType mapping to Entity");

        TicketType ticketType = new TicketType();

        ticketType.setTicketTypeName(ticketApi.getType());


        logger.info("TicketType mapping to Entity-> all parameters set");

        return ticketType;
    }
}
