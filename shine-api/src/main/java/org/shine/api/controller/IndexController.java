package org.shine.api.controller;

import org.shine.api.filter.OAuth2TokenProcessingFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, value = "get", produces = "application/json")
	public ResponseEntity<OAuth2AccessToken> get(
			@RequestAttribute(name = OAuth2TokenProcessingFilter.ACCESS_TOKEN_VALUE) OAuth2AccessToken accessToken) {
		return new ResponseEntity<OAuth2AccessToken>(accessToken, HttpStatus.OK);
	}
}
