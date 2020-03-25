package com.example.ziragraphql.config.error;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class UnauthenticatedAccessException extends RuntimeException implements GraphQLError {
  public UnauthenticatedAccessException(String msg) {
    super(msg);
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.ValidationError;
  }

}
