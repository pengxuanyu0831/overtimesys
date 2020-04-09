package com.xuanyu.dao;

import com.xuanyu.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Scanner;


// @Repository
//public interface UserMapper {
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    // User selectByPrimaryKey(Scanner id);
//    User selectByPrimaryKey(Integer id);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
//}

public interface UserMapper{
    // 查询全部用户
    @Select("select * from user")
    public List<User> findUsers();
    // 用户注册
    @Insert("INSERT INTO USER (username,PASSWORD) VALUES(#{username},#{PASSWORD})")
    public void insetrUser(User user);
    // 用户登录
    @Select("select * from user where username=#{username} and PASSWORD=#{PASSWORD}")
    public User login(User user);

    // void findUser();
}