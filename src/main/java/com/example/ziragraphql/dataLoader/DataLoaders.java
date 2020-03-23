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
//      return resultValidate(list, users);
      return users;
  });

  private final BatchLoader<String, Ticket> ticketBatchLoader = (List<String> list) -> null;

  private final BatchLoader<String, Project> projectBatchLoader = (List<String> list) ->
    CompletableFuture.supplyAsync(() -> {
      List<Project> projects = projectService.getProjectByIds(list);
//      return resultValidate(list, projects);
      return projects;
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
    Iterator<T> iterator = input.iterator();
    T tmp = iterator.next();
    for (int i = 0; i < list.size(); i++) {
      tmp = iterator.hasNext() ? iterator.next() : null;
      System.out.println("***************");
      System.out.println(list.get(i));
      System.out.println(tmp.getId());
      System.out.println(i);
      System.out.println("***************");

      if (tmp != null && list.get(i).equals(tmp.getId())) {
        result.add(tmp);
        System.out.println("***************");
        System.out.println(tmp.getId());
        System.out.println("***************");
      } else {
        result.add(null);
      }
    }
    return result;
  }
}
