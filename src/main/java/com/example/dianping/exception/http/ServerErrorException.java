package com.example.dianping.exception.http;

/**
 * @author zh
 * @date 2021/7/9 16:23
 * ServerErrorException
 */
public class ServerErrorException extends HttpException {
    public ServerErrorException(int code) {
        this.code = code;
        this.httpStatusCode = 500;
    }
}
