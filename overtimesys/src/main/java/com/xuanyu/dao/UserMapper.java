package com.xuanyu.dao;

import com.xuanyu.model.User;
import org.springframework.stereotype.Repository;

import java.util.Scanner;


@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Scanner id);
    // User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}