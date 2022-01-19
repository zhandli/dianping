package com.example.dianping.validator.impl;

import com.example.dianping.validator.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期校验器实现
 *
 * @author zh
 * @date 2021/7/15 10:24
 */
public class DateTimeFormatValidator implements ConstraintValidator<DateTimeFormat, String> {

    private static final Logger logger = LoggerFactory.getLogger(DateTimeFormatValidator.class);

    private DateTimeFormat dateTimeFormat;

    /**
     * 校验
     *
     * @param value 传入值
     * @param constraintValidatorContext 上下文
     * @return 是否成功
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        String format = dateTimeFormat.pattern();

        if (value.length() != format.length()) {
            return false;
        }

        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat(format);
        try {
            simpleDateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            logger.warn("DateTimeFormat 校验异常", e);
            return false;
        }
    }

    @Override
    public void initialize(DateTimeFormat dateTime) {
        this.dateTimeFormat = dateTime;
    }
}
