package com.example.dianping.exception.http;
/**
 * @author zh
 * @date 2021/7/9 16:19
 * NotFoundExceptionš▒╗
 */
public class NotFoundException extends HttpException {

    public NotFoundException(int code) {
        this.code = code;
        this.httpStatusCode = 404;
    }
}
