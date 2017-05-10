package com.lorszil.service;

import com.lorszil.model.ApiAuthentication;
import com.lorszil.model.User;
import com.lorszil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public class ApiAuthenticationService {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";

    @Autowired
    UserRepository userRepository;


    public Authentication getAuth(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader(AUTH_HEADER_NAME);
        User user = userRepository.findByToken(token);
        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("No user found");
        }
        if (user.getToken() == null) {
            throw new AuthenticationCredentialsNotFoundException("No token found");
        }
        return new ApiAuthentication(user);
    }
}