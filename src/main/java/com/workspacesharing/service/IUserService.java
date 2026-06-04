package com.workspacesharing.service;

import com.workspacesharing.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User register(User user);
    List<User> findAll();
    void deleteById(Long  id);
    Optional<User> findByEmail(String email);
}
