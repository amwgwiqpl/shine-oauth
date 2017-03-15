package com.shine.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.util.StringUtils;

import com.google.common.collect.Sets;

public class Developer implements ClientDetails {

  private static final long serialVersionUID = 7318058928169089456L;

  private String clientId;
  private String clientSecret;

  private String authorizedGrantTypes;

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
    this.authorizedGrantTypes = authorizedGrantTypes;
  }

  public Developer() {
    this.clientId = "";
    this.clientSecret = "";
    this.authorizedGrantTypes = "";
  }

  public Developer(String clientId, String clientSecret, String authorizedGrantTypes) {
    this();
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  @Override
  public String getClientId() {
    // TODO Auto-generated method stub
    return this.clientId;
  }

  @Override
  public Set<String> getResourceIds() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isSecretRequired() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getClientSecret() {
    // TODO Auto-generated method stub
    return this.clientSecret;
  }

  @Override
  public boolean isScoped() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Set<String> getScope() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Set<String> getAuthorizedGrantTypes() {
    // TODO Auto-generated method stub
    Set<String> grantTypes = Sets.newHashSet();
    if (StringUtils.hasText(this.authorizedGrantTypes)) {
      StringTokenizer tokenizer = new StringTokenizer(authorizedGrantTypes, ",");
      while (tokenizer.hasMoreElements()) {
        grantTypes.add(tokenizer.nextToken());
      }
    }
    System.out.println(" grantTypes = " + grantTypes);
    return grantTypes;
  }

  @Override
  public Set<String> getRegisteredRedirectUri() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    GrantedAuthority authority = new SimpleGrantedAuthority("USER");
    Collection<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(authority);
    return authorities;
  }

  @Override
  public Integer getAccessTokenValiditySeconds() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Integer getRefreshTokenValiditySeconds() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAutoApprove(String scope) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Map<String, Object> getAdditionalInformation() {
    // TODO Auto-generated method stub
    return null;
  }

}
