package com.xuanyu.model;

import java.util.Scanner;

/**
 * @author admin
 */
public class User {
    private Integer id;

    private String name;

    private String email;

    private String password;

    public Integer getId(Scanner sc) {
        return id;
    }

    public Integer getid(){ return  id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}