package com.example.ziragraphql.model.ticket;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketQuery implements GraphQLQueryResolver {

  @Autowired
  private TicketService ticketService;

  public Ticket getTicketById(String id) {
    return ticketService.getTicketById(id);
  }

  public List<Ticket> getPagedTicket(String projectName, int pageSize, int pageNum) {
    return ticketService.getPagedTickets(projectName, pageSize, pageNum);
  }

  public Ticket getTicketByNumber(String projectName, String ticketNumber) {
    return ticketService.getTicketByTicketName(projectName, ticketNumber);
  }
}
