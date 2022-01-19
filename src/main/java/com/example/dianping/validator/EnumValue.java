package com.example.dianping.validator;

import com.example.dianping.validator.impl.EnumValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 必须为枚举中的一项
 *
 * @author zh
 * @date 2021/7/14 17:35
 */
@Documented
@Target({FIELD, TYPE_USE, TYPE_PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = EnumValueValidator.class)
public @interface EnumValue {

    Class<? extends Enum> target();

    String message() default "value must in enum";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
