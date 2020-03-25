package com.example.ziragraphql.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "essproperties")
public class EssSettings {
  private String jwtTokenSecret;
  private Integer userTokenDuration;

  public String getJwtTokenSecret() {
    return jwtTokenSecret;
  }

  public Integer getUserTokenDuration() {
    return userTokenDuration;
  }

  public void setJwtTokenSecret(String jwtTokenSecret) {
    this.jwtTokenSecret = jwtTokenSecret;
  }

  public void setUserTokenDuration(Integer userTokenDuration) {
    this.userTokenDuration = userTokenDuration;
  }
}
