package com.shine.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.shine"})
public class ShineWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShineWebApplication.class, args);
  }
}
