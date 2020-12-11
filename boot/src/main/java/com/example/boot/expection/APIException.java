package com.example.boot.expection;

public class APIException extends RuntimeException {
    private int code;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public APIException() {
        this(1001, "接口错误");
    }
    public APIException(String msg) {
        this(1001, msg);
    }
    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    }
