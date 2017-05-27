package org.shine.api.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {
	@Autowired
	private ResourceServerTokenServices tokenServices;

	@RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
	public ResponseEntity<String> get(OAuth2Authentication authentication) {
		OAuth2AuthenticationDetails oAuth2AuthenticationDetails = (OAuth2AuthenticationDetails) authentication
				.getDetails();
		Map<String, Object> additionalInfo = tokenServices.readAccessToken(oAuth2AuthenticationDetails.getTokenValue())
				.getAdditionalInformation();
		// Member member = (Member) additionalInfo.get("member");
		return new ResponseEntity<String>("Your UUID: " + additionalInfo.get("member").toString() + " , your username: "
				+ authentication.getPrincipal() + " and your role USER", HttpStatus.OK);
	}
}
