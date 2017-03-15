package com.shine.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShineWebApplicationTests {


  public void before() {
    ResourceOwnerPasswordResourceDetails passwordDetails =
        new ResourceOwnerPasswordResourceDetails();
    passwordDetails.setClientAuthenticationScheme(AuthenticationScheme.query);
    passwordDetails.setClientId("manager");
    passwordDetails.setClientSecret("xpto");
    passwordDetails.setAccessTokenUri("http://localhost:9094/oauth/token");
    passwordDetails.setScope(Lists.newArrayList("openid"));
  }


  @Test
  public void contextLoads() {

  }

}
