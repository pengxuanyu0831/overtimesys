package com.xuanyu.controller;

import com.xuanyu.model.User;
import com.xuanyu.service.EmailService;
import com.xuanyu.service.imple.EmailServiceImp;
import com.xuanyu.service.imple.UserServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/**
 * @author xuanyu
 */



@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    protected UserServiceImple userService;

    @Autowired
    protected EmailServiceImp emailServiceImp;

    @RequestMapping("/findUser")
    public String findUsers(Model model){
        System.out.println("controller：findUsers");
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
    public String insertUser(@RequestBody  @ModelAttribute("infoModel") @Validated User user ,BindingResult bindingResultUser) throws MessagingException {
        System.out.println("注册ing...");
//        List<Object> allErrors = Collections.singletonList(bindingResultUser.getAllErrors());
//        User userhvtest = userService.insetrUser(user);
        if (bindingResultUser.hasErrors()) {
            System.out.println("校验失败");
            return "redirect:/toRegister.jsp";
        }
        System.out.println("注册成功，写入数据库");
        // md5加密
        userService.encryptedPassword(user);
        userService.insertUser(user);
//        userService.insetrUser(userService);
        String url = "${pageContext.request.contextPath}"+ "/user/active?id=" + user.getId();
        emailServiceImp.sendMail(user,"注册账号",url);
        return "successlogin";
    };
    /*
    @param email

     */
    @RequestMapping("/validatorEmailExist")
    public void validatorEmailExist(String email , PrintWriter writer){
        System.out.println("校验邮箱中...");
        User user = userService.validatorEmailExist(email);
        System.out.println("邮箱校验完成");
        if(user != null && user.getId() != null){
            writer.write("hasEmail");
        }else {
            writer.write("noEmail");
        }
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

    @RequestMapping("/active")
    public String active(String id)throws Exception{
        User user = (User) userService.selectByPrimaryKey(id);
        String title = "";
        String content = "";
        String subject ="";

        if(user != null){
            if(System.currentTimeMillis() - user.getTokenTime().getTime() < 86400000){
                userService.insertUser(user);
                title="成功激活";
                content = "成功激活账号";
                subject = "激活成功";
            }
            else{
                title="激活失败";
                content = "激活时间大于24小时";
                subject="请重新发送激活邮件";
            }
        }
        return "index";
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