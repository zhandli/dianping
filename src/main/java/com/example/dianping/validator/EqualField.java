package com.example.dianping.validator;


import com.example.dianping.validator.impl.EqualFieldValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 比较两个属性是否相等
 *
 * @author zh
 * @date 2021/7/14 14:28
 */

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = EqualFieldValidator.class)
public @interface EqualField {
    /**
     * 源属性
     */
    String srcField();

    /**
     * 目标属性
     */
    String dstField();

    String message() default "the two fields must be equal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
