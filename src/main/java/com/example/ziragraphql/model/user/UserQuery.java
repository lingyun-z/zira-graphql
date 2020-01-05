package com.example.ziragraphql.model.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserQuery implements GraphQLQueryResolver {

  @Autowired
  private UserService userService;

  public User getUserById(String id) {
    return userService.getUserById(id);
  }
}
