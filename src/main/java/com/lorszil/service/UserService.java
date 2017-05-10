package com.lorszil.service;

import com.lorszil.model.User;
import com.lorszil.model.Roles;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(int id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    void create(User user, Roles role);

    void deleteAllUsers();

}