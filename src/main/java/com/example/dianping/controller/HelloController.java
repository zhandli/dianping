package com.example.dianping.controller;

import com.example.dianping.utils.RequestUtil;
import com.example.service.HelloService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zh
 * @date 2021/7/14 13:41
 */
@RestController
@RequestMapping("test")
@Validated
public class HelloController {
    private int password;

    private int confirmPasswod;

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        HttpServletRequest request = RequestUtil.getRequest();

        System.out.println(RequestUtil.getRequestUrl());

        System.out.println(RequestUtil.getSimpleRequest());

        helloService.sayhello();
        return "hello";
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @Test
    public void test() {
        System.out.println(password == confirmPasswod);
    }


}
