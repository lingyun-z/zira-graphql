package com.example.ziragraphql.dataLoader;

import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.entity.User;
import org.dataloader.BatchLoader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoaders {

  private final BatchLoader<String, User> userBatchLoader = (List<String> list) -> null;

  private final BatchLoader<String, Ticket> ticketBatchLoader = (List<String> list) -> null;

  public BatchLoader<String, User> getUserBatchLoader() {
    return userBatchLoader;
  }

  public BatchLoader<String, Ticket> getTicketBatchLoader() {
    return ticketBatchLoader;
  }
}
