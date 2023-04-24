package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("borrow")
public class BoInfo {
    @TableId
    private String isbn;
    @TableField
    private String name;
    @TableField
    private String author;
    @TableField
    private String borrower;
    @TableField
    private List<String> date;
    @TableField
    private String status;

    public BoInfo(String isbn, String name, String autor, String borrower, List<String> date, String status) {
        this.isbn = isbn;
        this.name = name;
        this.author = autor;
        this.borrower = borrower;
        this.date = date;
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
