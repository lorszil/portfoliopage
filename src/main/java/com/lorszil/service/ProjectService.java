package com.lorszil.service;

import com.lorszil.model.Project;

import java.util.Collection;
import java.util.Optional;

public interface ProjectService {

    Optional<Project> getProjectById(int id);

    Optional<Project> getProjectByTitle(String title);

    Collection<Project> getAllProjects();

    void create(Project project);

    void deleteAllProjects();

}
