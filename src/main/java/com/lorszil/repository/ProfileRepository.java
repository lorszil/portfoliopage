package com.lorszil.repository;

import com.lorszil.model.Profile;
import com.lorszil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByUser(User user);
}