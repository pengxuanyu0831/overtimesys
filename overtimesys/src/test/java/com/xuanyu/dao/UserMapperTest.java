package com.xuanyu.dao;

import com.xuanyu.model.User;
import com.xuanyu.dao.UserMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

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
        user.setName("xuanyutest777777777777777");
        user.setPassword("736499");
        user.setEmail("abcdecf@gmail.com");
        int result = userMapper.insert(user);
        System.out.println(result);
        assert (result==1);

    }
    @Test
    public void testselect()throws Exception{
        User user = new User();
        Scanner sc = new Scanner(System.in);
        user.getId(sc);
        User result1 = userMapper.selectByPrimaryKey(sc);
        while (sc.hasNext()){
            System.out.println(result1+sc.next());
        }
    }
}