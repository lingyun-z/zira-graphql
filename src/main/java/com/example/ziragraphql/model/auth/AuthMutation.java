package com.example.ziragraphql.model.auth;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.ziragraphql.entity.Auth;
import com.example.ziragraphql.entity.Response;
import com.example.ziragraphql.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthMutation implements GraphQLMutationResolver {
  @Autowired
  private AuthService authService;

  public Response deleteProjectAuth(String id) {
    Integer result = authService.deleteProjectAuth(id);
    if (result == 1) {
      return new Response("success");
    }
    return new Response("fail");
  }

  public Auth addProjectAuth(Auth auth) {
    return authService.addAuth(auth);
  }

  public Auth updateProjectAuth(Auth auth) {
    return authService.updateAuth(auth.getId(), auth);
  }
}
