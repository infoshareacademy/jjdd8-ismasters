package com.isa.mapper;

import com.isa.domain.api.TicketApi;
import com.isa.domain.entity.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

@Stateless
public class TicketMapper {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public TicketType mapApiToEntity(TicketApi ticketApi) {

        TicketType ticketType = new TicketType();

        ticketType.setTicketTypeName(ticketApi.getType());

        logger.debug("TicketType mapping to Entity-> all parameters set  TicketType {}", ticketType.getTicketTypeName());

        return ticketType;
    }
}
