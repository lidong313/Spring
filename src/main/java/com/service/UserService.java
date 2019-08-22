package com.service;

import com.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    public User findName(String name);


    public List<String> queryPermissionById(Integer id);
}
