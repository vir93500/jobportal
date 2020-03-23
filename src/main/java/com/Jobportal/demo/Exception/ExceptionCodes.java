package com.Jobportal.demo.Exception;

public enum ExceptionCodes {

    USER_ALREADY_EXIST("JOB-ERR-1000","User already exist"),
    USER_NOT_FOUND("JOB-ERR-1001","User is not logged in"),
    INSUFFICIENT_MONEY_REQUESTED("WAL-ERR-1002","Money requested is not sufficient"),
    SUBSCRIPTION_ALREADY_EXIST("SUB-ERR-1003","Subscription already exist");


    private String errCode;
    private String errMsg;

    private ExceptionCodes(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String errCode() {
        return this.errCode;
    }

    public String errMsg() {
        return this.errMsg;
    }
}
