package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("token")
public class Token {
    @TableId
    private String account;
    @TableField
    private String token_info;


    public Token(String account, String token_info) {
        this.account = account;
        this.token_info = token_info;
    }


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken_info() {
        return token_info;
    }

    public void setToken_info(String token_info) {
        this.token_info = token_info;
    }
}
