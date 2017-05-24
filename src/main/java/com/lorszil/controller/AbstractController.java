package com.lorszil.controller;


import com.lorszil.model.Profile;
import com.lorszil.model.Project;
import com.lorszil.repository.ProjectRepository;
import com.lorszil.service.ProjectService;
import com.lorszil.service.ProjectServiceImpl;
import com.lorszil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
abstract class AbstractController {


    @Autowired
    ProjectRepository projectRepository;


}