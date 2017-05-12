package com.shine.web.config.wrapper;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.shine.web.model.Member;

public class MemberTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		// TODO Auto-generated method stub
		Member member = (Member) authentication.getPrincipal();

		Map<String, Object> additionalInformation = new LinkedHashMap<String, Object>();

		additionalInformation.put("member", member);

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);

		return accessToken;
	}

}
