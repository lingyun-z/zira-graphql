package com.example.ziragraphql.model.project;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.ziragraphql.entity.Project;
import com.example.ziragraphql.entity.Response;
import com.example.ziragraphql.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectMutation implements GraphQLMutationResolver {
  @Autowired
  private ProjectService projectService;

  public Project addProject(Project project) {
    return projectService.addProject(project);
  }

  public Project updateProject(Project project) {
    return projectService.updateProject(project.getId(), project);
  }

  public Response deleteProjectById(String id){
    int result = projectService.deleteProjectById(id);
    return new Response(result == 1 ? "success" : "failed");
  }
}
