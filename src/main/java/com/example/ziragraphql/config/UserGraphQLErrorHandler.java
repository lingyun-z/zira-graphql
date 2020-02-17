package com.example.ziragraphql.config;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserGraphQLErrorHandler implements GraphQLErrorHandler {
  @Override
  public boolean errorsPresent(List<GraphQLError> errors) {
    for (GraphQLError error: errors) {
      if (!(errors instanceof ExceptionWhileDataFetching || errors instanceof Throwable)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public List<GraphQLError> processErrors(List<GraphQLError> errors) {
    return errors;
  }
}
