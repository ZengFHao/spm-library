package com.spread.libserver.model.network;

import com.spread.libserver.mapper.Vo.BookVo;
import com.spread.libserver.model.constant.Message;
import com.spread.libserver.model.dao.BoInfo;

import java.util.List;

public class BoInfoResponse extends Response{
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

    private List<BookVo> InfoList;

    public BoInfoResponse(boolean status) {
        super(status);
    }

    public BoInfoResponse(boolean status, String op, Message msg) {
        super(status, op, msg);
    }

    public BoInfoResponse(boolean status, String op) {
        super(status, op);
    }

    public List<BookVo> getInfoList() {
        return InfoList;
    }

    public void setInfoList(List<BookVo> infoList) {
        InfoList = infoList;
    }
}
