package com.shine.web.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("authorizationRequest")
public class ApprovalController {

  @RequestMapping("/oauth/confirmAccess")
  public ModelAndView getAccessConfirmation(Map<String, Object> model, Principal principal)
      throws Exception {
    System.out.println("213123");
    return new ModelAndView("access_confirmation", model);
  }
}
