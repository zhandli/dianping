package com.example.dianping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zh
 * @date 2021/7/11 10:32
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.example.dianping.mapper"})
public class DianpingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DianpingApplication.class, args);
        String[] contextBeanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : contextBeanDefinitionNames) {
            System.out.println(s);
        }
    }

}
