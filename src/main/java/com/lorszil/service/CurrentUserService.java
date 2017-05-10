package com.lorszil.service;

import com.lorszil.model.CurrentUser;

public interface CurrentUserService {
    boolean canAccessUser(CurrentUser currentUser, int userId);
}
