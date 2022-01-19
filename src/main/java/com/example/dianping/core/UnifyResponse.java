package com.example.dianping.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 *
 * 	200：表示成功
 * 	500：表示服务器内部错误，错误信息在text字段中
 * 	400：异常统一返回
 * 	502：拦截器拦截到用户token出错
 *
 * @author zh
 * @date 2021/7/9 20:38
 */
@Data
public class UnifyResponse {

    /**
     * 定义jackson对象
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 返回空数组
     */
    private static final Object[] EMPTY_OBJECT = {};

    /**
     * 状态码
     */
    private Integer status;

    /**
     * 相应消息
     */
    private String text;

    /**
     * 响应中的数据
     */
    private Object data;

    /**
     * 不使用
     */
    @JsonIgnore
    private String ok;

    public UnifyResponse() {

    }

    public UnifyResponse(Integer status, String text, Object data) {
        this.status = status;
        this.text = text;
        this.data = data;
    }

    public UnifyResponse(Object data) {
        this.status = 200;
        this.text = "OK";
        this.data = data;
    }
    
    public static UnifyResponse ok(Object data) {
        return new UnifyResponse(data);
    }

    public static UnifyResponse ok() {
        return new UnifyResponse(EMPTY_OBJECT);
    }
    
    public static UnifyResponse errorText(String text) {
        return new UnifyResponse(500, text, EMPTY_OBJECT);
    }

    public static UnifyResponse errorText(Integer status, String text) {
        return new UnifyResponse(status, text, EMPTY_OBJECT);
    }

    public static UnifyResponse errorText() {
        return new UnifyResponse(500, "服务器内部错误", EMPTY_OBJECT);
    }

    public Boolean isOk() {
        return this.status == 200;
    }

}
