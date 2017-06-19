package com.lorszil.config;

import com.lorszil.model.Profile;
import com.lorszil.model.Project;
import com.lorszil.model.Roles;
import com.lorszil.model.User;
import com.lorszil.repository.ProfileRepository;
import com.lorszil.repository.ProjectRepository;
import com.lorszil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DataLoader {


    @Autowired
    private ProjectRepository projectRepository;


    @Autowired
    private UserService userService;

    @Autowired
    private ProfileRepository profileRepository;

    @PostConstruct
    public void loadProjects() {
        if (projectRepository.findAll().isEmpty()) {
            Project project = new Project("Portrait - Kinga", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis");
            Project project2 = new Project("Street photo", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis");
            projectRepository.save(project);
            projectRepository.save(project2);
        }
    }

    @PostConstruct
    public void loadAdmin() {
        if (userService.getUserByEmail("admin@admin.com").equals(Optional.empty())) {
            User admin = new User("admin@admin.com", "12345");
            userService.create(admin, Roles.ADMIN);
            Profile profile = new Profile(admin);
            profileRepository.save(profile);
        }
    }
}
