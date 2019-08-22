package com.dao;

import com.entity.User;

import java.util.List;

public interface UserMapper {

    public User findName(String name);


    public List<String> queryPermissionById(Integer id);


}
