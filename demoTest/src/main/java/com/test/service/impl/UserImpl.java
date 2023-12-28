package com.test.service.impl;

import com.test.mapper.UserMapper;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.getUserByAandP(user);
    }
}
