package com.xuanyu.controller;

import java.security.NoSuchAlgorithmException;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.xuanyu.model.ValidateModel;


@Controller
@RequestMapping(value = "/validate")
public class ValidateController {

    @RequestMapping(value = "/ruler" ,method = {RequestMethod.GET})
    public String ruler(Model model){
        // contentmodel 是指啥？
        if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel" ,new ValidateModel());
        }
        return "validaterluer";
    }

    @RequestMapping(value = "/ruler",method = {RequestMethod.POST})
    public String ruler (Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel,BindingResult result) throws
            NoSuchAlgorithmException{

        if(result.hasErrors())
            return ruler(model);
        return "index.jsp";
        }
    }

