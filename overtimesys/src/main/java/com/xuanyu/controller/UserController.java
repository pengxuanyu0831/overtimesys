package com.xuanyu.controller;

import com.xuanyu.model.User;
import com.xuanyu.service.imple.UserServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.List;

/**
 * @author xuanyu
 */



@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    protected UserServiceImple userService;

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
     */
    @RequestMapping(value = "/insertUser")
    //开启数据校验，添加在类上用于校验方法，添加在方法参数中用于校验参数对象。(添加在方法上无效)
    @Validated
    // 对象校验
    public String insertUser(@RequestBody @Validated @ModelAttribute("infoModel") User user ,BindingResult bindingResultUser) {
        System.out.println("注册ing...");
//        User userhvtest = userService.insetrUser(user);
        if (bindingResultUser.hasErrors()) {
            System.out.println("校验失败");
            return "redirect:/toRegister.jsp";
        }
        System.out.println("注册成功，写入数据库");
        userService.insertUser(user);
//        userService.insetrUser(userService);
        return "successlogin";
    };
    /*
    @param email

     */
    @RequestMapping("/validatorEmailExist")
    public PrintWriter validatorEmailExist(String email , PrintWriter writer)throws Exception{
        System.out.println("校验邮箱中...");
        User user = userService.validatorEmailExist(email);
        System.out.println("邮箱校验完成");
        if(user != null && user.getId() != null){
            writer.write("hasEmail");
        }else {
            writer.write("noEmail");
        }
        return writer;
    }

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
//