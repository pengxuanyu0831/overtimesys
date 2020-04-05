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

/**
 * @author xuanyu
 */
@Controller
@RequestMapping("/user")
    public class UserController {
    @Autowired
    private UserMapper userMapper;

    /* @RequestMapping (value = "/pwd" , method = RequestMethod.POST)
     * 这样也行
     */
    @PostMapping (value = "/pwd")
    public String pwdTest(@RequestParam("userid") int userid ,Model model){
        User user = userMapper.selectByPrimaryKey(userid);
        model.addAttribute("username" , user.getName());
        model.addAttribute("password" , user.getPassword());
        return "secondRound";
    }
}
