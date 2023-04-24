package com.spread.libserver.model.network;

import com.spread.libserver.model.constant.Message;
import com.spread.libserver.model.dao.Category;

import java.util.List;

public class CategoryResponse extends Response{

    private int pageNum;
    private int numEachPage;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getNumEachPage() {
        return numEachPage;
    }

    public void setNumEachPage(int numEachPage) {
        this.numEachPage = numEachPage;
    }

    private List<Category> categories;

    public CategoryResponse(boolean status, String op, Message msg) {
        super(status, op, msg);
    }

    public CategoryResponse(boolean status, String op) {
        super(status, op);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
