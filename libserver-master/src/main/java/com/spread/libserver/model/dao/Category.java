package com.spread.libserver.model.dao;

import com.baomidou.mybatisplus.annotation.*;

@TableName("category")
public class Category {
    @TableId("category_id")
    private int id;

    @TableField(value = "category_parent_id")
    private int pid;

    @TableField("category_name")
    private String name;

    @TableField("category_isdeepest")
    private boolean isDeepest;

    public Category(String name, boolean isDeepest) {
        this.name = name;
        this.isDeepest = isDeepest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeepest() {
        return isDeepest;
    }

    public void setDeepest(boolean deepest) {
        isDeepest = deepest;
    }
}