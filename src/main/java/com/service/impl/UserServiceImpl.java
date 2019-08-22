package com.service.impl;

import com.dao.UserMapper;
import com.entity.User;
import com.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<String> queryPermissionById(Integer id) {
        return userMapper.queryPermissionById(id);
    }

    @Override
    public User findName(String name) {
        return userMapper.findName(name);
    }
}
