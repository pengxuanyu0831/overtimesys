//package com.xuanyu.controller;
//
//import java.security.NoSuchAlgorithmException;
//import javax.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import com.xuanyu.model.ValidateModel;
//
///**
// * 把数据绑定到contentmodel
// * 绑定后开始校验
// */
//@Controller
//@RequestMapping(value = "/validate")
//public class ValidateController {
//
//    // @RequestMapping(value = "/ruler" ,method = {RequestMethod.GET}) 第一种写法
//    @GetMapping(value = "/ruler")
//    public String ruler(Model model){
//        // contetnmodel 将数据绑定到model上 的模型
//        if(!model.containsAttribute("contentModel")){
//            model.addAttribute("contentModel" ,new ValidateModel());
//        }
//        return "validaterluer";
//    }
//
//    @RequestMapping(value = "/ruler",method = {RequestMethod.POST})
//    // 在把数据绑定到@ModelAttribute("contentModel") 后就进行验证。
//    public String ruler (Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel,BindingResult result) throws
//            NoSuchAlgorithmException{
//        // 有错误返回登录页
//        if(result.hasErrors())
//            return ruler(model);
//        return "index.jsp";
//        }
//    }
//
