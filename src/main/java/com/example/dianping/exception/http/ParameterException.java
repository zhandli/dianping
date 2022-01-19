package com.example.dianping.exception.http;

/**
 * @author zh
 * @date 2021/7/9 16:21
 * ParameterException
 */
public class ParameterException extends HttpException {
    public ParameterException(int code) {
        this.code = code;
        this.httpStatusCode = 400;
    }
}
