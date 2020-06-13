package com.xuanyu.dao;

import com.xuanyu.model.User;
import org.apache.ibatis.annotations.*;
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
@Repository
public interface UserMapper{
    // 查询全部用户
    @Select("select * from user")
    public List<User> findUsers();
    // 用户注册
    @Insert("INSERT INTO USER (name,password,email,salt,token_exptime) VALUES(#{name},#{password},#{email},#{salt},now())")
    public void insertUser(User user);
    // 用户登录
    @Select("select * from user where name=#{name} and password=#{password}")
    public User login(User user);

    @Select("select * from user where id = #{id}")
    public


    User validatorEmailExist(String email);

    User validatorUserExist(String email);

    User encryptedPassword(String password);

    // @Delete("")

    // void findUser();
}