package com.xuanyu.service;
import com.xuanyu.model.User;
import java.util.List;

public interface UserService {
    // 查询全部用户
    public List<User>findUsers();
    public User insetrUser(User user);
    public boolean login(User user);
}
