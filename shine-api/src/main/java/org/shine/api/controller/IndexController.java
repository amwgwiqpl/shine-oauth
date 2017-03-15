package org.shine.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {
  
  @RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
  @ResponseBody
  public String get() {
    return String.format("%s you as ADMIN", "UUID.rand  omUUID().toString()");
  }
}
