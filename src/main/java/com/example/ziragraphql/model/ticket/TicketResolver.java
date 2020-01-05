package com.example.ziragraphql.model.ticket;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketResolver implements GraphQLResolver<Ticket> {

  @Autowired
  private UserService userService;

  public User getCreatedUser(Ticket ticket) {
    return userService.getUserById(ticket.getCreatedBy());
  }

  public User getAssigneeUser(Ticket ticket) {
    return userService.getUserById(ticket.getAssignee());
  }
}
