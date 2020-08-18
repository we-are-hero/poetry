package com.hero.poetry.common.utils;

/**
 * 状态码
 */
public enum ResultCode {
    SUCCESS(20000),
    ERROR(20001),
    ANSWER_TIME_OUT_ERROR(20002),
    UPDATE_ERROR(20003),
    ILLEGAL_ACCESS_ERROR(20004);

    private int code;

    ResultCode(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
