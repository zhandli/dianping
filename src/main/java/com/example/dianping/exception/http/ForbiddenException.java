package com.example.dianping.exception.http;

/**
 * @author zh
 * @date 2021/7/9 16:47
 * ForbiddenException
 */
public class ForbiddenException extends HttpException {
    public ForbiddenException(int code) {
        this.code = code;
        this.httpStatusCode = 403;
    }
}
