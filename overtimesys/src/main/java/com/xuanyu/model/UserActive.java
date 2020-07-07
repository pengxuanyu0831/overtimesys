package com.xuanyu.model;

import java.io.Serializable;

public class UserActive implements Serializable {
    private String id;
    private String name;
    private String email;
    private String password;


    public String getId(){
        return id;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public void setId(String id){
        this.id = id;
    }





}
