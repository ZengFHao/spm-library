package com.spread.libserver.model.network;

import com.spread.libserver.model.constant.Message;
import com.spread.libserver.model.dao.Book;

import java.util.List;

public class BookResponse extends Response{

    private List<Book> books;

    public BookResponse(boolean status, String op, Message msg) {
        super(status, op, msg);
    }

    public BookResponse(boolean status, String op) {
        super(status, op);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
