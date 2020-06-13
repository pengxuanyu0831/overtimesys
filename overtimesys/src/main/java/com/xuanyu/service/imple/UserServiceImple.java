package com.xuanyu.service.imple;
import com.xuanyu.dao.UserMapper;
import com.xuanyu.dao.ValidatorMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import com.xuanyu.model.User;
import com.xuanyu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


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
    public User insertUser(User user){
        System.out.println("业务层：用户注册");
        userMapper.insertUser(user);
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

    @Override
    public User validatorEmailExist(String email) {
        // 这个好像根本没被调用？
        System.out.println("校验用户是否注册");
        return userMapper.validatorEmailExist(email);
    }

    @Override
    public User validatorUserExits(String email) {
        System.out.println("校验用户是否激活");
        return userMapper.validatorUserExist(email);
    }

    @Override
    public User encryptedPassword(User user){
        String salt = UUID.randomUUID().toString();
        Md5Hash md5hsah = new Md5Hash(user.getPassword(),salt,2);
        user.setPassword(md5hsah.toString());
        user.setSalt(salt);
        // System.out.println(salt.toString());
        return user;
    }

}
