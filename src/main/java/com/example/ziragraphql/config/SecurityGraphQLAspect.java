package com.example.ziragraphql.config;

import com.example.ziragraphql.context.UserContext;
import com.example.ziragraphql.context.UserContextHolder;
import com.example.ziragraphql.entity.User;
import com.example.ziragraphql.util.JWToKenUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class SecurityGraphQLAspect {
  @Autowired
  private JWToKenUtil jwToKenUtil;

  @Before("allGraphQLResolverMethods() && !isMethodAnnotatedAsUnsecured()")
  public void doSecurityCheck() throws Exception {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    String token = requestAttributes.getRequest().getHeader("Authorization");
    System.out.println("***************************");
    System.out.println(token);
    System.out.println("***************************");
    User user = jwToKenUtil.parseToken(token);
    UserContext context = UserContextHolder.get();
    context.setUser(user);
//    throw new Exception("aaaaaaaaaaa");
  }

  @Pointcut("target(com.coxautodev.graphql.tools.GraphQLQueryResolver) || target(com.coxautodev.graphql.tools.GraphQLMutationResolver)")
  private void allGraphQLResolverMethods() {
  }

  @Pointcut("@annotation(com.example.ziragraphql.config.Unsecured)")
  private void isMethodAnnotatedAsUnsecured() {
  }
}
