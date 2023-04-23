package com.spread.libserver.model.constant;

public class Message {
    private String code;
    private String content;


    public Message(String code, String content) {
        this.code = code;
        this.content = content;
    }


    public String getCode() {
        return code;
    }

    public String getContent() {
        return content;
    }
}
