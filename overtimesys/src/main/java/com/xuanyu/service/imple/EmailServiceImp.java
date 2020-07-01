package com.xuanyu.service.imple;

import com.xuanyu.model.User;
import com.xuanyu.service.EmailService;
import com.xuanyu.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImp implements EmailService {
    @Autowired
    // 注入Spring封装的javamail，Spring的xml中已让框架装配
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;


    @Override
    public void sendMail(User user, String content, String url) throws MessagingException {
        System.out.println("邮件发送中..");
//        mailMessage(user,content,url);
//    }
//
    /*@Override
                      ####MimeMessage是发附件用的#####
            public void mailMessage(User user, String content, String url ) throws MessagingException {
//        Map<String,Object> map = new HashMap();
//        map.put("name",user.getName());
//        map.put("content",content);
//        map.put("url",url);

                MimeMessage mine = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mine, true,"utf-8");

                helper.setFrom("739421672@qq.com");
                helper.setTo(user.getEmail());
                helper.setSubject("注册用户");
                helper.setText(user.getContent(),true);
*/
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("739421672@qq.com");
        message.setTo(user.getEmail());
        message.setSubject("注册邮件");
        message.setText(url);


        mailSender.send(message);
    }
//    public JavaMailSender getMailSender() {
//        return mailSender;
//    }

}
