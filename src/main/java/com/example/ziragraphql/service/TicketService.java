package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
  @PostMapping
  Ticket addTicket(@RequestBody Ticket ticket);

  @PutMapping("/{id}")
  Ticket updateTicket(@PathVariable("id") String id, @RequestBody Ticket ticket);

  @DeleteMapping("/{id}")
  int deleteTicket(@PathVariable("id") String id);
}
