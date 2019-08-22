package com.test;

import com.dao.UserMapper;
import com.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testFindName(){
        User user = userMapper.findName("zhangsan");
        System.out.println(user);


    }
}
