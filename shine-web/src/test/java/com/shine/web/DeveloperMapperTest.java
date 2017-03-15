package com.shine.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.shine.mapper")
public class DeveloperMapperTest extends AbstractTransactionalJUnit4SpringContextTests {

  @Autowired
  @Qualifier("developerService")
  private ClientDetailsService developerServiceImpl;

  @Test
  public void testQueryByClientId() {
    ClientDetails developer =
        this.developerServiceImpl.loadClientByClientId("58c51cba-87a3-4d19-a34f-45731383ba86");

    System.out.println(developer.getClientSecret());
    System.out.println(developer.getAuthorizedGrantTypes());
  }
}
