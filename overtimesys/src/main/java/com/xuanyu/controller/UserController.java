package com.xuanyu.controller;

import com.xuanyu.dao.UserMapper;
import com.xuanyu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Scanner;

/**
 * @author xuanyu
 */
@Controller
@RequestMapping("/user")
    public class UserController {
    @Autowired
    private UserMapper userMapper;

    /* @RequestMapping (value = "/pwd" , method = RequestMethod.POST)
     * 这样也行 2020-04-05
     */
    @PostMapping (value = "/pwd")
    public String pwdTest(@RequestParam("id") Scanner id , Model model){
        User user = userMapper.selectByPrimaryKey(id);
        //User user = userMapper.insert(id);
        model.addAttribute("username" , user.getName());
        model.addAttribute("password" , user.getPassword());
        return "secondRound";
    }
}
