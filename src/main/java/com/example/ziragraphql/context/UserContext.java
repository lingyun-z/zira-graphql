package com.example.ziragraphql.context;

import com.example.ziragraphql.entity.User;

public class UserContext {
  private User user;

  public UserContext() {
  }

  public UserContext(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
