package com.example.dianping.core;

import com.example.dianping.core.configuration.ExceptionCodeConfiguration;
import com.example.dianping.exception.http.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zh
 * @date 2021/7/9 16:42
 * 错误拦截
 */
@ControllerAdvice
public class GlobalExceptionAdvice {
    /**
     * exceptionCodeConfiguration 全局异常处理器
     */
    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    /**
     * 返回空数组
     */
    private static final Object[] EMPTY_OBJECT = {};

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionAdvice.class);


    /**
     * 未知异常处理
     * @param req HttpServletRequest
     * @param e 未知异常
     * @return  UnifyResponse
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus
    public UnifyResponse handleException(HttpServletRequest req, Exception e) {
        // 未知异常
        logger.error("服务器内部错误", e);
        return UnifyResponse.errorText();
    }

    /**
     * 已知异常处理
     * @param response HttpServletResponse
     * @param e 已知异常
     * @return UnifyResponse
     */
    @ExceptionHandler(HttpException.class)
    @ResponseBody
    public UnifyResponse handleHttpException(HttpServletResponse response, HttpException e){
        response.setStatus(e.getHttpStatusCode());
        return new UnifyResponse(e.getHttpStatusCode(), codeConfiguration.getMessage(e.getCode()), EMPTY_OBJECT);

    }
}
