package com.example.ziragraphql.context;

import com.example.ziragraphql.entity.User;
import graphql.servlet.GraphQLContext;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.HandshakeRequest;

public class AuthContext extends GraphQLContext {
  private User user;

  public AuthContext(HttpServletRequest httpServletRequest, HandshakeRequest handshakeRequest, Subject subject, User user) {
    super(httpServletRequest, handshakeRequest, subject);
    this.user = user;
  }

}
