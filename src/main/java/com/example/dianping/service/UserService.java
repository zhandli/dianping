package com.example.dianping.service;

import com.example.dianping.pojo.User;
import com.example.dianping.pojo.dto.RegisterUserDTO;

import java.util.List;

/**
 * @author zh
 * @date 2021/7/11 10:54
 */
public interface UserService {

    /**
     * 根据id查询user
     *
     * @param id userId
     * @return  value for User
     */
    User getUser(Integer id);

    /**
     * 注册用户
     *
     * @param registerUserDTO registerUserDTO
     * @return value for User
     */
    User register(RegisterUserDTO registerUserDTO);

    /**
     * 批量更新user
     *
     * @param users 待更新的user内容
     * @return 更新成功数量
     */
    Integer updateUser(List<User> users);
}
