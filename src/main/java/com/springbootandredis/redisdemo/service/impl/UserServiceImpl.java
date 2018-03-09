package com.springbootandredis.redisdemo.service.impl;


import com.springbootandredis.redisdemo.mapper.UserMapper;
import com.springbootandredis.redisdemo.model.User;
import com.springbootandredis.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ${todo}...
 * ${tags}
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @CachePut(value="userCache",key = "#user.userName",condition = "#user.userName<='100'")
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        return userMapper.selectAllUser();
    }

    @Override
    @Cacheable(value="userCache1",key="'user:'+#userId",unless = "#result==null")
    public User queryUser(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        System.out.println("第一次查询时，走这里，并将数据存储在redis数据库中:"+user.toString());
        return user;
    }
}
