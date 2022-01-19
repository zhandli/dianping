package com.example.dianping.validator.impl;

import com.example.dianping.validator.EqualField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;
import java.lang.reflect.Field;

/**
 * 相等值校验器
 * 第二个参数为这个校验器所支持的被校验元素的类型
 *
 * @author zh
 * @date 2021/7/14 14:37
 */
public class EqualFieldValidator implements ConstraintValidator<EqualField, Object> {
    /**
     * Logger日志
     */
    private static final Logger logger  = LoggerFactory.getLogger(EqualFieldValidator.class);

    /**
     * 源属性
     */
    private String srcField;

    /**
     * 目标属性
     */
    private String dstField;


    @Override
    @SuppressWarnings("squid:S3011")
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Class<?> clazz = object.getClass();

        Field field0 = ReflectionUtils.findField(clazz, this.srcField);
        Field field1 = ReflectionUtils.findField(clazz, this.dstField);

        try {
            if (field0 == null || field1 == null) {
                throw new ValidationException("反射获取变量失败");
            }

            field0.setAccessible(true);
            field1.setAccessible(true);

            Object src = field0.get(object);
            Object dst = field1.get(object);

            if (src == null || dst == null) {
                return src == dst;
            }

            // 比较内存地址
            if (src == dst) {
                return true;
            }
            return src.equals(dst);
        } catch (Exception e) {
            logger.warn("EqualFieldValidator 校验异常", e);
            return false;
        }
    }

    @Override
    public void initialize(EqualField constraintAnnotation) {
        this.srcField = constraintAnnotation.srcField();
        this.dstField = constraintAnnotation.dstField();
    }
}
