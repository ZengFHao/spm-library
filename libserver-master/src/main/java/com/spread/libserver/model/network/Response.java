package com.spread.libserver.model.network;

import com.spread.libserver.model.constant.Message;

/**
 * All the responses that will be sent to client.
 * It is not abstract because if I don't need extra
 * information but just want to tell the client whether
 * it's request is successful or not, I can use this
 * class to do it.
 * <p>
 * TODO -> Change msg into Wrap Class.
 */

public class Response {
    private boolean status;
    private String op;
    private Message msg;

    public Response(boolean status) {
        this.status = status;
    }

    public Response(boolean status, String op, Message msg) {
        this.status = status;
        this.op = op;
        this.msg = msg;
    }

    public Response(boolean status, String op) {
        this.status = status;
        this.op = op;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }
}
