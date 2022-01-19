package com.example.dianping.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author zh
 * @date 2021/7/11 22:34
 */
@Data
public class RegisterUserDTO {
    /**
     * telephone
     */
    @NotBlank(message = "手机号不能为空")
    private String telephone;

    /**
     * telephone
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * gender
     */
    @NotNull(message = "性别不能为空")
    private Integer gender;

    /**
     * nickName
     */
    @NotBlank(message = "昵称不能为空")
    private String nickName;

}
