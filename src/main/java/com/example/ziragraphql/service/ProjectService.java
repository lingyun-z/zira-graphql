package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "zira-user", path = "/project")
public interface ProjectService {
  @PostMapping("/{id}")
  Project addProject(@RequestBody Project project, @PathVariable("id") String userId);

  @PutMapping("/{id}")
  Project updateProject(@PathVariable("id") String id, @RequestBody Project project);

  @GetMapping("/{id}")
  Project getProjectById(@PathVariable("id") String id);

  @DeleteMapping("/{id}")
  int deleteProjectById(@PathVariable("id") String id);

  @PostMapping("/batch")
  List<Project> getProjectByIds(@RequestBody List<String> ids);

  @GetMapping("/name/{name}")
  Project getProjectByName(@PathVariable("name") String name);
}
