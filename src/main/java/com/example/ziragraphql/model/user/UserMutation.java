package com.example.ziragraphql.model.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.ziragraphql.config.Unsecured;
import com.example.ziragraphql.entity.Response;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {
  @Autowired
  private UserService userService;

  @Unsecured
  public User addUser(User user) {
    return userService.addUser(user);
  }

  public User updateUser(User user) {
    return userService.updateUser(user.getId(), user);
  }

  public Response deleteUserById(String id) {
    int result = userService.deleteUserById(id);
    return new Response(result == 1 ? "success" : "failed");
  }
}
