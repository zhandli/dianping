package com.example.dianping.validator.impl;

import com.example.dianping.validator.EnumValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

/**
 * 必须指定枚举中的值
 *
 * @author zh
 * @date 2021/7/14 17:56
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(EnumValueValidator.class);

    /**
     * 枚举类
     */
    private Class<?> cls;

    /**
     * 校验
     *
     * @param value 传入值
     * @param constraintValidatorContext constraintValidatorContext
     * @return 是否校验成功
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (cls == null) {
            return true;
        }
        try {
            Object[] objs = cls.getEnumConstants();
            Method method = cls.getMethod("getValue");
            for (Object obj : objs) {
                Object val = method.invoke(obj);
                if (val.equals(value)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            logger.warn("EnumValue 校验异常", e);
            return false;
        }
    }

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        cls = constraintAnnotation.target();
    }
}
