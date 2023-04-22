package com.spread.libserver.model.network;

import com.spread.libserver.model.constant.Message;
import com.spread.libserver.model.dao.Borrow;

import java.util.List;

public class BorrowResponse extends Response{

    private List<Borrow> borrows;

    public BorrowResponse(boolean status) {
        super(status);
    }

    public BorrowResponse(boolean status, String op, Message msg) {
        super(status, op, msg);
    }

    public BorrowResponse(boolean status, String op) {
        super(status, op);
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }
}
