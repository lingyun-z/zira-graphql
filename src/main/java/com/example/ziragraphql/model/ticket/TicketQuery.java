package com.example.ziragraphql.model.ticket;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketQuery implements GraphQLQueryResolver {

  @Autowired
  private TicketService ticketService;

  public Ticket getTicketById(String id) {
    return ticketService.getTicketById(id);
  }
}
