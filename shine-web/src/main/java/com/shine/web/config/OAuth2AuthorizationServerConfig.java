package com.shine.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.shine.web.config.wrapper.DefaultOAuth2RequestFactoryWrapper;

@Configuration
@EnableAuthorizationServer
@EnableConfigurationProperties(ResourceServerProperties.class)
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private RedisConnectionFactory factory;
  @Autowired
  @Qualifier("developerService")
  private ClientDetailsService clientDetailsService; // 开发者帐号
  @Autowired
  private UserDetailsService userDetailsService; // 使用者用户帐号

  @Autowired
  private ResourceServerProperties resourceServerProperties;

  @Bean
  public TokenStore tokenStore() {
    return new RedisTokenStore(factory);
  }

  @Bean
  public ApprovalStore approvalStore() {
    return new JdbcApprovalStore(dataSource);
  }

  @Bean
  public OAuth2RequestFactory oAuth2RequestFactory() {
    return new DefaultOAuth2RequestFactoryWrapper(this.clientDetailsService);
    
  }

  @Bean
  @Primary
  public DefaultTokenServices tokenServices() {
    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setTokenStore(tokenStore());
    defaultTokenServices.setSupportRefreshToken(true);
    return defaultTokenServices;
  }

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // TODO Auto-generated method stub
    clients.withClientDetails(clientDetailsService)
        .withClient(this.resourceServerProperties.getServiceId());
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    // TODO Auto-generated method stub
    endpoints.requestFactory(this.oAuth2RequestFactory())
        .pathMapping("/oauth/confirm_access", "/oauth/confirmAccess")
        .authenticationManager(this.authenticationManager).tokenStore(this.tokenStore())
        .userDetailsService(this.userDetailsService).approvalStore(this.approvalStore());
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.allowFormAuthenticationForClients();
  }
}
