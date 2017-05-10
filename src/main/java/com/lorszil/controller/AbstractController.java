package com.lorszil.controller;


import com.lorszil.model.Profile;
import com.lorszil.model.User;
import com.lorszil.repository.ProfileRepository;
import com.lorszil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

abstract class AbstractController {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UserService userService;

    Profile getCurrentProfile(Principal principal) {
        return profileRepository.findByUser(getCurrentUser(principal));
    }

    User getCurrentUser(Principal principal) {
        return userService.getUserByEmail(principal.getName()).get();
    }

}