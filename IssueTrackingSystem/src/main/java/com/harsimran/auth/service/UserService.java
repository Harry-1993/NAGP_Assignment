package com.harsimran.auth.service;

import com.harsimran.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
