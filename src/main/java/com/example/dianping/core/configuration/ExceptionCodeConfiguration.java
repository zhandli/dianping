package com.example.dianping.core.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zh
 * @date 2021/7/9 16:19
 * 错误码配置类
 */
@Component
@PropertySource(value = {"classpath:config/exception-code.properties"}, encoding = "utf-8")
@ConfigurationProperties(prefix = "zh")
public class ExceptionCodeConfiguration {
    /**
     * 存放错误码key和value的数据结构
     */
    private Map<Integer, String> codes = new HashMap<>();

    /**
     * 得到错误码map的value(string)
     * @param code
     * @return
     */
    public String getMessage(int code) {
        return codes.get(code);
    }

    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setCodes(Map<Integer, String> codes) {
        this.codes = codes;
    }
}
