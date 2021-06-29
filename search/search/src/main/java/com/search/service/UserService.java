package com.search.service;

import com.search.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User findOne(String id);
    User create(User user);
    User update(User user);
    List<User> getUserByUsername(String username);
    void delete(String id);
}
