package com.example.dianping.validator;

import com.example.dianping.validator.impl.DateTimeFormatValidator;
import com.example.dianping.validator.impl.EnumValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 日期格式校验，是否匹配给定的模式
 * yyyy-MM-dd HH-mm-ss
 *
 * @author zh
 * @date 2021/7/15 10:22
 */
@Documented
@Target({FIELD, TYPE_USE, TYPE_PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = DateTimeFormatValidator.class)
public @interface DateTimeFormat {

    String message() default "date pattern invalid";

    String pattern() default "yyyy-MM-dd HH-mm-ss";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
