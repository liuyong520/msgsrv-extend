package com.nnk.msgsrv.exception;

public class MsgSrvSpringProviderBeanException extends RuntimeException {
    private String code;
    private String msg;

    public MsgSrvSpringProviderBeanException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MsgSrvSpringProviderBeanException(String message, String code, String msg) {
        super(message);
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
