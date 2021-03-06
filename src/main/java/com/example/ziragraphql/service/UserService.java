package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "zira-user", path = "/user")
public interface UserService {
  @PostMapping
  User addUser(@RequestBody User user);

  @PutMapping("/{id}")
  User updateUser(@PathVariable("id") String id, @RequestBody User user);

  @GetMapping("/{id}")
  User getUserById(@PathVariable("id") String id);

  @DeleteMapping("/{id}")
  int deleteUserById(@PathVariable("id") String id);

  @PostMapping("/batch")
  List<User> getUserByIds(@RequestBody List<String> ids);

  @GetMapping("/all")
  List<User> getAllUser();

  @PostMapping("/valid")
  User vaildUser(@RequestBody User user);
}
