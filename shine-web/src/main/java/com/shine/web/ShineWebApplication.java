package com.shine.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shine"})
public class ShineWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShineWebApplication.class, args);
  }
}
