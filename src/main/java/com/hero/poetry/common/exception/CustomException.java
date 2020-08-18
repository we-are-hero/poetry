package com.hero.poetry.common.exception;

import com.hero.poetry.common.utils.ResultCode;

public class CustomException extends RuntimeException{
    private ResultCode resultCode;

    public CustomException(String s) {
        super(s);
        resultCode = ResultCode.ERROR;
    }

    public CustomException(ResultCode resultCode,String s) {
        super(s);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
