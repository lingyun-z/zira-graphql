package com.example.ziragraphql.model.ticket;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.ziragraphql.context.UserContextHolder;
import com.example.ziragraphql.entity.Response;
import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMutation implements GraphQLMutationResolver {
  @Autowired
  private TicketService ticketService;

  public Ticket addTicket(Ticket ticket) {
    String userId = UserContextHolder.get().getUser().getId();
    ticket.setCreatedBy(userId);
    return ticketService.addTicket(ticket);
  }

  public Ticket updateTicket(Ticket ticket) {
    return ticketService.updateTicket(ticket.getId(), ticket);
  }

  public Response deleteTicketById(String id){
    int result = ticketService.deleteTicket(id);
    return new Response(result == 1 ? "success" : "failed");
  }
}
