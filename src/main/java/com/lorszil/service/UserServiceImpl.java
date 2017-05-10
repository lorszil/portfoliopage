package com.lorszil.service;

import com.lorszil.model.User;
import com.lorszil.repository.UserRepository;
import com.lorszil.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    public UserServiceImpl() {
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override

    public void create(User user, Roles role) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole(role);
        user.setToken(UUID.randomUUID().toString());
        userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}