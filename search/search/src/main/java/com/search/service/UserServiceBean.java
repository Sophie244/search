package com.search.service;

import com.google.common.collect.Lists;
import com.search.dao.UserRepository;
import com.search.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public User findOne(String id) {
        return repository.findById(id).orElseGet(null);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User persitedUser = repository.findById(user.getId()).orElseGet(null);
        if(persitedUser == null) {
            return null;
        }
        return repository.save(user);
    }

    @Override
    public List<User> getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
