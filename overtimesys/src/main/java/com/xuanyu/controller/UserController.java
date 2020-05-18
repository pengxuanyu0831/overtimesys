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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


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
    @RequestMapping("/insert")
    @Validated
    public String insert(@Validated User user , BindingResult bindingResultUser,
                         @Validated Email email,BindingResult bindingResultEmail) throws Exception {
        System.out.println("注册");
        //校验失败跳转到登录页
        List<ObjectError>allErrorsUser = bindingResultUser.getAllErrors();
        if (allErrorsUser != null && allErrorsUser.size()>0) {
            return "redirect:/index";
        }
        List<ObjectError>allErrorsEmail = bindingResultEmail.getAllErrors();
        if(allErrorsEmail != null  ){
            return "redirect:/index";
        };
        // 调用注入的 usersService 调用 insertUsers 方法
        userService.insetrUser(user);
        return "index";
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