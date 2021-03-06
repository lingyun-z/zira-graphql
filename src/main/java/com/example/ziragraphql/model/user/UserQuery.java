package com.example.ziragraphql.model.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ziragraphql.config.EssSettings;
import com.example.ziragraphql.config.Unsecured;
import com.example.ziragraphql.context.UserContext;
import com.example.ziragraphql.context.UserContextHolder;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.entity.UserToken;
import com.example.ziragraphql.service.UserService;
import com.example.ziragraphql.util.JWToKenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserQuery implements GraphQLQueryResolver {
  @Autowired
  private UserService userService;

  @Autowired
  private JWToKenUtil jwToKenUtil;

  @Autowired
  private EssSettings essSettings;

  public User getUserById(String id) {
    return userService.getUserById(id);
  }

  public User getCurrentUser() {
    UserContext context = UserContextHolder.get();
    String userId = context.getUser().getId();
    return userService.getUserById(userId);
  }

  public List<User> getAllUser() {
    return userService.getAllUser();
  }

  @Unsecured
  public UserToken getUserToken(User user) {
    User vaildUser = userService.vaildUser(user);
    if (vaildUser != null) {
      return jwToKenUtil.createUserToken(vaildUser);
    }
    return null;
  }
}
