package com.xuanyu.xuanyu.dao;

import com.xuanyu.model.User;
import com.xuanyu.dao.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {

    private ApplicationContext applicationContext;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        //spring 配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        //测试用Mapper
        userMapper = applicationContext.getBean(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testinstert() throws Exception{
        User user = new User();
        // Integer id = 1;
        // new user.setId("77777");
        user.setName("xuanyutest777777777777777");
        user.setPassword("736499");
        user.setEmail("abcdecf@gmail.com");
        int result = userMapper.insert(user);
        // User result1 = userMapper.selectByPrimaryKey(id);
        System.out.println(result);
        // System.out.println(result1);
        assert (result==1);

    }
}