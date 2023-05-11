package org.ll.review.service.impl;

import org.ll.review.entity.pojo.User;
import org.ll.review.mapper.UserMapper;
import org.ll.review.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(Long id) {
       return userMapper.selectById(id);
    }
}
