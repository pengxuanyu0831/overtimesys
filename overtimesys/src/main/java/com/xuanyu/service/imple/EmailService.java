package com.xuanyu.service.imple;

import com.xuanyu.model.User;
import com.xuanyu.utils.FreeMarkerUtils;
import freemarker.template.TemplateException;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pengxy
 */
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    public void sendEmail(User user, String content , String url) throws Exception {
        String returnText = createSendData(user,content,url);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
        mimeMessageHelper.setFrom(simpleMailMessage.getFrom()) ;
        mimeMessageHelper.setSubject(simpleMailMessage.getSubject());
        // 接受邮件用户的邮箱
        mimeMessageHelper.setTo(user.getEmail());
        // 邮件内容
        mimeMessageHelper.setText(returnText,true);
        mailSender.send(mimeMessage);

    }

    private String createSendData(User user, String content, String url) throws IOException, TemplateException {
        Map<String,Object>map =new HashMap();
        map.put("NikeName",user.getName());
        map.put("Email",user.getEmail());
        map.put("url",url);
        map.put("content",content);
        //map.put("endurl", Bas)

        String returnText = new FreeMarkerUtils().returnText("email.ftl",map);
        return returnText;
    }


}
