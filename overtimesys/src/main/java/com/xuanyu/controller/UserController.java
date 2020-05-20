package com.xuanyu.controller;

import com.xuanyu.dao.UserMapper;
import com.xuanyu.model.User;
import com.xuanyu.service.UserService;
import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Scanner;

/**
 * @author xuanyu
 */





@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findUser")
    public String findUsers(Model model){
        System.out.println("表现层：查询用户");
        //调用service对象的方法进行测试
        List<User> list = userService.findUsers();
        model.addAttribute("list",list);
        return "User";
    }

    /**
     * 用户注册
     * @param user
     * @return 注册成功跳到首页
     * 先校验是否存在
     */
    @RequestMapping(value = "/insert",method = {RequestMethod.POST})
    //开启数据校验，添加在类上用于校验方法，添加在方法参数中用于校验参数对象。(添加在方法上无效)
    @Validated
    // 对象校验
    public User insertUsert(@RequestBody @Validated User user ,
                         BindingResult bindingResultUser){
        System.out.println("注册ing...");
        User userhvtest = userService.insetrUser(user);
        return userhvtest;

//        if (bindingResultUser.hasErrors()){
//            return "index";
//        }
//        else{
//            userService.insetrUser(user);
//            return "successlogin";
//        }

//    public HVtest insert(@Validated User user ,BindingResult bindingResult){
//        HVtest hvtset = userService.insetrUser(user);
//        return hvtest;



//
        // redirect  重定向到index.jsp
    };

    /**
     * 用户登录
     * @param user
     * @return 登录成功跳转到successlogin页面
     */
    @RequestMapping("/login")
    public String login(User user) {
        System.out.println("登录");
        // 调用注入的 userService 调用 login 方法
        if(userService.login(user)){
            return "successlogin";
        }else{
            return "falselogin";
        }
    }
}



//==============================初版===============================
//@Controller
//@RequestMapping("/user")
//    public class UserController {
//    @Autowired
//    private UserMapper userMapper;
//
//    /* @RequestMapping (value = "/pwd" , method = RequestMethod.POST)
//     * 这样也行 2020-04-05
//     */
//    @PostMapping (value = "/pwd")
//    public String pwdTest(@RequestParam("id") Integer id , Model model){
//        User user = userMapper.selectByPrimaryKey(id);
//        //User user = userMapper.insert(id);
//        model.addAttribute("username" , user.getName());
//        model.addAttribute("password" , user.getPassword());
//        return "secondRound";
//    }
//}
//==============================================================