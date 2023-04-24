package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.*;

@TableName("book")
public class Book {
    @TableId("book_id")
    private int bookId;

    @TableField("book_isbn")
    private String bookIsbn;

    @TableField("book_name")
    private String bookName;

    @TableField("book_author")
    private String bookAuthor;

    @TableField("book_publisher")
    private String bookPublisher;

    @TableField("book_summary")
    private String bookSummary;

    @TableField("book_cover")
    private String bookCover;

    @TableField(value = "book_price")
    private float bookPrice;

    @TableField("book_stock")
    private int bookStock;

    @TableField("book_category_name")
    private String bookCategoryName;


    /**
     * Without this, error will occur when call "bookMapper.selectOne()":
     *      Cannot determine value type from string 'haha.png'
     *
     *      <a href="https://blog.csdn.net/kingwinstar/article/details/107106239">...</a>
     */
    public Book() {

    }

    public Book(String bookIsbn, String bookName, String bookAuthor, String bookPublisher, String bookSummary,
                String bookCover, float bookPrice, int bookStock, String bookCategoryName) {
        this.bookIsbn = bookIsbn;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookSummary = bookSummary;
        this.bookCover = bookCover;
        this.bookPrice = bookPrice;
        this.bookStock = bookStock;
        this.bookCategoryName = bookCategoryName;
    }

    public boolean beBorrowed(){
        if(bookStock > 0){
            --this.bookStock;
            return true;
        }
        return false;
    }

    public boolean beReturned(){
        ++this.bookStock;
        return true;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int bookStock) {
        this.bookStock = bookStock;
    }

    public String getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(String bookCategoryName) {
        this.bookCategoryName = bookCategoryName;
    }
}
