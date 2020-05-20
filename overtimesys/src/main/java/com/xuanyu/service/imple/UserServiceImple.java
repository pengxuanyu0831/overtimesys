package com.xuanyu.service.imple;
import com.xuanyu.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuanyu.model.User;
import com.xuanyu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("usersService")
public class UserServiceImple implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User>findUsers(){
        System.out.println("业务层 ：查询所有用户");
        return userMapper.findUsers();
    }

    @Override
    public User insetrUser(User user){
        System.out.println("业务层：用户注册");
        userMapper.insetrUser(user);
        return user;
    }

    @Override
    public boolean login(User user){
        System.out.println("业务层：用户登录");
        if(userMapper.login(user)==null){
            return false;
        }else {
            return true;
        }
    }
}
