package com.example.dianping.controller;

import com.example.dianping.core.UnifyResponse;
import com.example.dianping.pojo.User;
import com.example.dianping.pojo.dto.RegisterUserDTO;
import com.example.dianping.service.UserService;
import com.example.dianping.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author zh
 * @date 2021/7/11 10:36
 */
@RestController
@RequestMapping("user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public User getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("updateUser")
    public UnifyResponse updateUser(@RequestBody List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return UnifyResponse.ok();
        }
        Integer successUpdate = userService.updateUser(users);
        return UnifyResponse.ok(successUpdate);
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/register")
    @ResponseBody
    public UnifyResponse register(@RequestBody @Validated RegisterUserDTO registerUserDTO) throws NoSuchAlgorithmException {
        registerUserDTO.setPassword(MD5Utils.getMd5Str(registerUserDTO.getPassword()));
        User user = userService.register(registerUserDTO);
        return UnifyResponse.ok(user);

    }
}
