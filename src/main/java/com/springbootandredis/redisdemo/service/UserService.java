package com.springbootandredis.redisdemo.service;


import com.springbootandredis.redisdemo.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);

    User queryUser(Integer userId);
}
