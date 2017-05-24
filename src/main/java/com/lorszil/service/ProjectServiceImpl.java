package com.lorszil.service;


import com.lorszil.model.Project;
import com.lorszil.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public ProjectServiceImpl() {
    }

    @Override
    public Optional<Project> getProjectById(int id) {
        return Optional.ofNullable(projectRepository.findOne(id));
    }

    @Override
    public Optional<Project> getProjectByTitle(String title) {
        return Optional.ofNullable(projectRepository.findByTitle(title));
    }

    @Override
    public Collection<Project> getAllProjects() {
        return projectRepository.findAll(new Sort("title"));
    }

    @Override

    public void create(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void deleteAllProjects() {
        projectRepository.deleteAll();
    }



}
