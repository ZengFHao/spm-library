package com.spread.libserver.model.network;

import com.spread.libserver.model.constant.Message;
import com.spread.libserver.model.dao.Account;

import java.util.List;

public class AccountResponse extends Response{

    private List<Account> accounts;

    public AccountResponse(boolean status, String op, Message msg) {
        super(status, op, msg);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
