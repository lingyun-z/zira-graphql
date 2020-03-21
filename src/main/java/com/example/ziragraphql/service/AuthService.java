package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.Auth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "zira-user", path = "/auth")
public interface AuthService {
  @GetMapping("/{userId}")
  List<Auth> getAuthByUserId(@PathVariable("userId") String userId);

  @GetMapping("/project/{id}")
  List<Auth> getAuthUserByProjectId(@PathVariable("id") String id);
}
