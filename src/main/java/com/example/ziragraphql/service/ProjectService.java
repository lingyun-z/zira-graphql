package com.example.ziragraphql.service;

import com.example.ziragraphql.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "zira-user", path = "/project")
public interface ProjectService {
  @PostMapping
  Project addProject(@RequestBody Project project);

//  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  @PutMapping("/{id}")
  Project updateProject(@PathVariable("id") String id, @RequestBody Project project);

  @GetMapping("/{id}")
  Project getProjectById(@PathVariable("id") String id);

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  int deleteProjectById(@PathVariable("id") String id);
}
