package com.example.ziragraphql.dataLoader;

import com.example.ziragraphql.entity.BaseEntity;
import com.example.ziragraphql.entity.Project;
import com.example.ziragraphql.entity.Ticket;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.service.ProjectService;
import com.example.ziragraphql.service.UserService;
import org.dataloader.BatchLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class DataLoaders {
  @Autowired
  private ProjectService projectService;

  @Autowired
  private UserService userService;

  private final BatchLoader<String, User> userBatchLoader = (List<String> list) ->
    CompletableFuture.supplyAsync(() -> {
      List<User> users = userService.getUserByIds(list);
      return resultValidate(list, users);
//      return users;
  });

  private final BatchLoader<String, Ticket> ticketBatchLoader = (List<String> list) -> null;

  private final BatchLoader<String, Project> projectBatchLoader = (List<String> list) ->
    CompletableFuture.supplyAsync(() -> {
      List<Project> projects = projectService.getProjectByIds(list);
      return resultValidate(list, projects);
//      return projects;
    });

  public BatchLoader<String, User> getUserBatchLoader() {
    return userBatchLoader;
  }

  public BatchLoader<String, Ticket> getTicketBatchLoader() {
    return ticketBatchLoader;
  }

  public BatchLoader<String, Project> getProjectBatchLoader() {
    return projectBatchLoader;
  }

  private <T extends BaseEntity> List<T> resultValidate(List<String> list, List<T> input) {
    List<T> result = new ArrayList<>();
    HashMap<String, T> map = new HashMap<>();
    input.stream().forEach(item -> map.put(item.getId(), item));
    list.stream().forEach(id -> result.add(map.get(id)));
    return result;
  }
}
