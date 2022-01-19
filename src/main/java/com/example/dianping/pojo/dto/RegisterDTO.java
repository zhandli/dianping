package com.example.dianping.pojo.dto;


import com.example.dianping.pojo.enums.YesOrNo;
import com.example.dianping.validator.EnumValue;
import com.example.dianping.validator.EqualField;
import lombok.Data;

/**
 * @author zh
 * @date 2021/7/14 16:41
 */
@Data
@EqualField(srcField = "password", dstField = "confirmPassword")
public class RegisterDTO {
    @EnumValue(target = YesOrNo.class)
    private YesOrNo username;

    private Integer password;

    private Integer confirmPassword;
}
