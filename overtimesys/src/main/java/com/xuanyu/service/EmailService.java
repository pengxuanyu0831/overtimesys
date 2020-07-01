package com.xuanyu.service;

import com.xuanyu.model.User;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {
    void sendMail(User user,String content,String url) throws MessagingException;

    // void mailMessage(User user , String content, String url) throws MessagingException;
}
