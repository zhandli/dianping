package com.example.dianping.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 路由信息收集器
 *
 * @author zh
 * @date 2021/8/2 14:15
 */
public class PermissionMetaCollector implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {


        return null;
    }
}
