package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "zira-ticket", path = "/ticket")
public interface TicketService {

  @GetMapping("/{id}")
  Ticket getTicketById(@PathVariable("id") String id);

//  Ticket getTicketByTicketName(String projectId, String ticketNumber);
//
//  List<Ticket> getPagedTickets(int pageSize, int pageNum, String projectId);
//
//  int getTicketCount(String projectId);
//
//  List<Ticket> getSubTicket(String id);
//
//  Ticket addTicket(Ticket ticket);
//
//  Ticket updateTicket(Ticket ticket);
//
//  int deleteTicket(String id);
}
