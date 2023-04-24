package com.spread.libserver.mapper.Vo;


public class BookVo {
    private String bookIsbn;
    private String bookName;
    private String bookAuthor;
    private String borrowAccount;
    private String borrowTime;
    private int borrowDuration;
    private int borrowIsOverTime;

    public BookVo(String bookIsbn, String bookName, String bookAuthor, String borrowAccount, String borrowTime, int borrowDuration, int borrowIsOverTime) {
        this.bookIsbn = bookIsbn;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.borrowAccount = borrowAccount;
        this.borrowTime = borrowTime;
        this.borrowDuration = borrowDuration;
        this.borrowIsOverTime = borrowIsOverTime;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBorrowAccount() {
        return borrowAccount;
    }

    public void setBorrowAccount(String borrowAccount) {
        this.borrowAccount = borrowAccount;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }

    public void setBorrowDuration(int borrowDuration) {
        this.borrowDuration = borrowDuration;
    }

    public int getBorrowIsOverTime() {
        return borrowIsOverTime;
    }

    public void setBorrowIsOverTime(int borrowIsOverTime) {
        this.borrowIsOverTime = borrowIsOverTime;
    }
}
