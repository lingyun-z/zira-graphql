package com.example.ziragraphql.model.project;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.ziragraphql.entity.Project;
import com.example.ziragraphql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectQuery implements GraphQLQueryResolver {
  @Autowired
  private ProjectService projectService;

  public Project getProjectById(String id) {
    return projectService.getProjectById(id);
  }
}
