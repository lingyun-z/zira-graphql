package com.example.ziragraphql.model.ticket;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.ziragraphql.entity.Project;
import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.service.ProjectService;
import com.example.ziragraphql.service.TicketService;
import com.example.ziragraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketResolver implements GraphQLResolver<Ticket> {

  @Autowired
  private UserService userService;

  @Autowired
  private ProjectService projectService;

  @Autowired
  private TicketService ticketService;

  public User getCreatedUser(Ticket ticket) {
    return userService.getUserById(ticket.getCreatedBy());
  }

  public User getAssigneeUser(Ticket ticket) {
    return ticket.getAssignee() == null ? null : userService.getUserById(ticket.getAssignee());
  }

  public Ticket getParentTicket(Ticket ticket) {
    return ticketService.getTicketById(ticket.getParentId());
  }

  public Project getProject(Ticket ticket) {
    return projectService.getProjectById(ticket.getProjectId());
  }
}
