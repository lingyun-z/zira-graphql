package com.example.ziragraphql.model.auth;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.ziragraphql.entity.Auth;
import com.example.ziragraphql.entity.Project;
import com.example.ziragraphql.entity.User;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AuthResolver implements GraphQLResolver<Auth> {


  public CompletableFuture<Project> getProject(Auth auth,  DataFetchingEnvironment env) {
    DataLoader<String, Project> dataloader = ((GraphQLContext) env.getContext())
            .getDataLoaderRegistry().get()
            .getDataLoader("projectBatchLoader");
    return dataloader.load(auth.getProjectId());
  }

  public CompletableFuture<User> getUser(Auth auth, DataFetchingEnvironment env) {
    DataLoader<String, User> dataloader = ((GraphQLContext) env.getContext())
            .getDataLoaderRegistry().get()
            .getDataLoader("userBatchLoader");
    return dataloader.load(auth.getUserId());
  }
}
