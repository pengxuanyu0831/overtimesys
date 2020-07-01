package com.xuanyu.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

/**
 * @author pengxy
 * @version UpToBlog V0.1
 */
public class User implements Serializable {
    // id 非空
    private Integer id;
    @NotEmpty(message = "{name.not.empty}")
    @Size(min=4,max=16,message = "{user.length.not.correct}")
    private String name;

    @Email(message = "{email.address.not.correct}")
    @NotEmpty(message = "{email.not.empty}")
    private String email;

    @NotEmpty(message = "{password.not.empty}")
    private String password;

    private String salt;

    private Date tokenTime;

    /** 发件人 **/
    private String fromAddress;

    /** 收件人 **/
    private String toAddress;

    /** 邮件主题 **/
    private String subject;

    /** 邮件内容 **/
    private String content;



    public String getFromAddress() {
        return fromAddress;
    }

    public Date getTokenTime(){
        return tokenTime;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId(){ return  id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }



    public String getSalt(){
        return salt;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }


    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ",email=' " + email + '\'' +
                '}';
    }
}