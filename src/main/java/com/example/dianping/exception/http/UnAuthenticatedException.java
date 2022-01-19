package com.example.dianping.exception.http;

/**
 * @author zh
 * @date 2021/7/9 16:29
 * UnAuthenticatedException
 */
public class UnAuthenticatedException extends HttpException {
    public UnAuthenticatedException(int code) {
        this.code = code;
        this.httpStatusCode = 401;
    }
}
