package com.example.ziragraphql.config;

import com.example.ziragraphql.context.UserContext;
import com.example.ziragraphql.context.UserContextHolder;
import com.example.ziragraphql.entity.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SecurityGraphQLAspect {
  @Before("allGraphQLResolverMethods() && !isMethodAnnotatedAsUnsecured()")
  public void doSecurityCheck() throws Exception {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    String token = requestAttributes.getRequest().getHeader("Authorization");
    System.out.println("***************************");
    System.out.println(token);
    System.out.println("***************************");
    UserContext context = UserContextHolder.get();
    context.setUser(new User("1bd358a8-24ac-11ea-b286-0242ac110002", "", "zhanglingyun", "zly@pwc.com"));
//    throw new Exception("aaaaaaaaaaa");
//    if (SecurityContextHolder.getContext() == null ||
//            SecurityContextHolder.getContext().getAuthentication() == null ||
//            !SecurityContextHolder.getContext().getAuthentication().isAuthenticated() ||
//            AnonymousAuthenticationToken.class.isAssignableFrom(SecurityContextHolder.getContext().getAuthentication().getClass())) {
//      throw new AccessDeniedException("User not authenticated");
//    }
  }

  @Pointcut("target(com.coxautodev.graphql.tools.GraphQLQueryResolver) || target(com.coxautodev.graphql.tools.GraphQLMutationResolver)")
  private void allGraphQLResolverMethods() {
  }

  @Pointcut("@annotation(com.example.ziragraphql.config.Unsecured)")
  private void isMethodAnnotatedAsUnsecured() {
  }
}
