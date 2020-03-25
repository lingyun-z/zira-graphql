package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.Auth;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "zira-user", path = "/auth")
public interface AuthService {
  @GetMapping("/{userId}")
  List<Auth> getAuthByUserId(@PathVariable("userId") String userId);

  @GetMapping("/project/{id}")
  List<Auth> getAuthUserByProjectId(@PathVariable("id") String id);

  @DeleteMapping("/{id}")
  Integer deleteProjectAuth(@PathVariable("id") String id);

  @PostMapping
  Auth addAuth(@RequestBody Auth auth);

  @PutMapping("/{id}")
  Auth updateAuth(@PathVariable("id") String id,@RequestBody Auth auth);

  @DeleteMapping("/project/{id}")
  List<Auth> deleteAuthUserByProjectId(@PathVariable("id") String id);
}
