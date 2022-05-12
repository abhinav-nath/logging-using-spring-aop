package com.codecafe.spring.aop.config;

import com.codecafe.spring.aop.entity.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SeedingConfiguration {

  @Bean
  public Map<Integer, Order> orders() {
    return new HashMap<>();
  }

}
