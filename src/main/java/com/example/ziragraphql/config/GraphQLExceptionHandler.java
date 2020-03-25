package com.example.ziragraphql.config;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GraphQLExceptionHandler implements GraphQLErrorHandler {
//  @Override
//  public boolean errorsPresent(List<GraphQLError> errors) {
//    for (GraphQLError error: errors) {
//      System.out.println("******************");
//      System.out.println(error.getMessage());
//      System.out.println("******************");
//      if (!(errors instanceof ExceptionWhileDataFetching || errors instanceof Throwable)) {
//        return true;
//      }
//    }
//    return false;
//  }

  @Override
  public List<GraphQLError> processErrors(List<GraphQLError> errors) {
    return errors.stream().map(this::getNested).collect(Collectors.toList());
  }

  private GraphQLError getNested(GraphQLError error) {
    if (error instanceof ExceptionWhileDataFetching) {
      ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
      if (exceptionError.getException() instanceof GraphQLError) {
        return (GraphQLError) exceptionError.getException();
      }
    }
    return error;
  }
}
