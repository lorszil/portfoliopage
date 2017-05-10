package com.lorszil.service;

import com.lorszil.model.CurrentUser;
import com.lorszil.model.Roles;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Override
    public boolean canAccessUser(CurrentUser currentUser, int userId) {
        return currentUser != null && (currentUser.getRole() == Roles.ADMIN || currentUser.getId() == userId);
    }
}