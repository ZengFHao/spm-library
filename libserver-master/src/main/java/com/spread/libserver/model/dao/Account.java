package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("account")
public class Account {
    @TableId("account_name")
    private String name;
    @TableField("account_password")
    private String password;

    @TableField("account_type")
    private int type;

    public Account(String n, String p, int t){
        name = n;
        password = p;
        type = t;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
