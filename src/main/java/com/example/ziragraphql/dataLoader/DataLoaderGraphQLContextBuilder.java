package com.example.ziragraphql.dataLoader;

import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLContextBuilder;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.HandshakeRequest;

@Component
public class DataLoaderGraphQLContextBuilder implements GraphQLContextBuilder {

  @Autowired
  private DataLoaders dataLoaders;

  @Override
  public GraphQLContext build(HttpServletRequest httpServletRequest) {
    GraphQLContext context = new GraphQLContext(httpServletRequest);
    context.setDataLoaderRegistry(buildDataLoaderRegistry());
    return context;
  }

  @Override
  public GraphQLContext build(HandshakeRequest handshakeRequest) {
    GraphQLContext context = new GraphQLContext(handshakeRequest);
    context.setDataLoaderRegistry(buildDataLoaderRegistry());
    return context;
  }

  @Override
  public GraphQLContext build() {
    GraphQLContext context = new GraphQLContext();
    context.setDataLoaderRegistry(buildDataLoaderRegistry());
    return context;
  }

  private DataLoaderRegistry buildDataLoaderRegistry() {
    DataLoaderRegistry dataLoaderRegistry = new DataLoaderRegistry();
    dataLoaderRegistry.register("userDataLoader", DataLoader.newDataLoader(dataLoaders.getUserBatchLoader()));
    dataLoaderRegistry.register("ticketBatchLoader", DataLoader.newDataLoader(dataLoaders.getTicketBatchLoader()));
    dataLoaderRegistry.register("projectBatchLoader", DataLoader.newDataLoader(dataLoaders.getProjectBatchLoader()));
    return dataLoaderRegistry;
  }
}
