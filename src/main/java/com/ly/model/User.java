package com.ly.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ly on 2017/10/8 17:53
 */
public class User {
    //主键
    private String id = UUID.randomUUID().toString();
    //用户名
    private String username;
    //密码
    private String password;
    //邮箱
    private String email;
    //创建时间
    private Date create_time = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}