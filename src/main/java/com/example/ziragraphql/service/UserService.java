package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zira-user", path = "/user")
public interface UserService {
//  User addUser(User user);
//
//  User updateUser(User user);

  @GetMapping("/{id}")
  User getUserById(@PathVariable("id") String id);

//  int deleteUserById(String id);
}
