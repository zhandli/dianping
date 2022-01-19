package com.example.dianping.exception.http;

/**
 * @author zh
 * @date 2021/7/9 16:45
 * http异常基类
 */
public class HttpException extends RuntimeException{
    /**
     * 错误码
     */
    int code;

    /**
     * http状态码
     */
    int httpStatusCode = 500;

    public int getCode() {
        return code;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}
