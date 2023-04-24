package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("borrow")
public class Borrow {
    // Must be wrapper class.
    @TableId(value = "borrow_id", type = IdType.ASSIGN_ID)
    private Integer id;

    @TableField("borrow_time")
    private String time;

    @TableField("borrow_book_id")
    private int bookId;

    @TableField("borrow_duration")
    private int duration;

    @TableField("borrow_is_over_time")
    private boolean isOverTime;

    @TableField("borrow_fine")
    private float fine;

    @TableField("borrow_account")
    private String account;

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", time=" + time +
                ", bookId=" + bookId +
                ", duration=" + duration +
                ", isOverTime=" + isOverTime +
                ", fine=" + fine +
                '}';
    }

//    public Borrow(String now, int id, String duration, boolean isOverTime, double v, String userName){
//
//    }

    public Borrow (){

    }
    public Borrow(String time, int bookId, int duration, boolean isOverTime, float fine, String account) {
        this.time = time;
        this.bookId = bookId;
        this.duration = duration;
        this.isOverTime = isOverTime;
        this.fine = fine;
        this.account = account;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isOverTime() {
        return isOverTime;
    }

    public void setOverTime(boolean overTime) {
        isOverTime = overTime;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
