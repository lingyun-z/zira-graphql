package com.example.ziragraphql.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfigration {
  @Bean
  Logger.Level feignLevel() {
    return Logger.Level.FULL;
  }
}
