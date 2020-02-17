package com.example.ziragraphql.model.auth;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ziragraphql.context.UserContext;
import com.example.ziragraphql.context.UserContextHolder;
import com.example.ziragraphql.entity.Auth;
import com.example.ziragraphql.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthQuery implements GraphQLQueryResolver {
  @Autowired
  private AuthService authService;

  public List<Auth> getAuthByUserId() throws Exception {
    UserContext context = UserContextHolder.get();
    return authService.getAuthByUserId(context.getUser().getId());
  }
}
