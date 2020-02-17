package com.example.ziragraphql.context;

public class UserContextHolder {
  private static ThreadLocal<UserContext> threadLocal = ThreadLocal.withInitial(UserContext::new);

  public static void set(UserContext context) {
    if (context == null) {

    }
    threadLocal.set(context);
  }

  public static UserContext get() {
    return threadLocal.get();
  }

  public static void clear() {
    threadLocal.remove();
  }
}
