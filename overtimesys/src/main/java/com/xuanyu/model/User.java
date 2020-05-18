package com.xuanyu.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Scanner;

/**
 * @author pengxy
 * @version UpToBlog V0.1
 */
public class User {
    private Integer id;
    @NotEmpty(message = "{name.not.empty}")
    private String name;
    @Email(message = "{email.address.not.correct}")
    @NotEmpty(message = "{email.not.empty}")
    private String email;
    @NotEmpty(message = "{password.not.empty}")
    private String password;

    /*public Integer getId(Scanner sc) {
        return id;
    }
     */




    public Integer getId(){ return  id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }


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