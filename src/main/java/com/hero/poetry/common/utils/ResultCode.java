package com.hero.poetry.common.utils;

/**
 * 状态码
 */
public enum ResultCode {
    SUCCESS(20000),
    ERROR(20001);

    private int code;

    ResultCode(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
