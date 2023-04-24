package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.*;

@TableName("book")
public class Book {
    @TableId("book_id")
    private int id;

    @TableField("book_isbn")
    private String ISBN;

    @TableField("book_name")
    private String name;

    @TableField("book_author")
    private String author;

    @TableField("book_publisher")
    private String pulisher;

    @TableField("book_summary")
    private String summary;

    @TableField("book_cover")
    private String cover;

    @TableField(value = "book_price")
    private float price;

    @TableField("book_stock")
    private int stock;

    @TableField("book_category_name")
    private String category;


    /**
     * Without this, error will occur when call "bookMapper.selectOne()":
     *      Cannot determine value type from string 'haha.png'
     *
     *      <a href="https://blog.csdn.net/kingwinstar/article/details/107106239">...</a>
     */
    public Book() {

    }

    public Book(String ISBN, String name, String author,
                String pulisher, String summary, String cover,
                float price, int stock, String category) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.pulisher = pulisher;
        this.summary = summary;
        this.cover = cover;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pulisher='" + pulisher + '\'' +
                ", summary='" + summary + '\'' +
                ", cover='" + cover + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }

    public boolean beBorrowed(){
        if(stock > 0){
            --this.stock;
            return true;
        }
        return false;
    }

    public boolean beReturned(){
        ++this.stock;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public String getPulisher() {
        return pulisher;
    }

    public void setPulisher(String pulisher) {
        this.pulisher = pulisher;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
