package com.test.service;

import com.test.pojo.User;

import java.util.List;

public interface UserService {
    User login(User user);
    List<User> getEmplist();
    void addEmpInfo(User user);
}
