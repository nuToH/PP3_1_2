package com.springboot2.service;

import com.springboot2.model.User;

import java.util.List;

public interface UserService {

    void add(User user);
    List<User> getList();
    User getUser(long id);
    void deleteUser(long id);
    void editUser(User user);
}
