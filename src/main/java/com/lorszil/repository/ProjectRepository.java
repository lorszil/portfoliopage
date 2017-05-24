package com.lorszil.repository;

import com.lorszil.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjectRepository extends JpaRepository<Project, Integer> {

    Project findByTitle(String title);

}
