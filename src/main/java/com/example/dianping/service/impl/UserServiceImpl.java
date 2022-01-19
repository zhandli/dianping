package com.example.dianping.service.impl;

import com.example.dianping.exception.http.NotFoundException;
import com.example.dianping.exception.http.ParameterException;
import com.example.dianping.mapper.UserMapper;
import com.example.dianping.pojo.User;
import com.example.dianping.pojo.dto.RegisterUserDTO;
import com.example.dianping.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zh
 * @date 2021/7/11 10:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @JsonFormat()
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            throw new NotFoundException(30001);
        }
        return user;
    }

    @Override
    public Integer updateUser(List<User> users) {
        List<Integer> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        int successUpdate = userMapper.batchUpdate(users);

        return successUpdate;
    }

    @Override
    @Transactional
    public User register(RegisterUserDTO registerUserDTO) {
        User user = new User();
        BeanUtils.copyProperties(registerUserDTO, user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());

        try {
            userMapper.insertSelective(user);
        } catch (DuplicateKeyException e) {
            throw new ParameterException(30002);
        }
        return user;
    }

}
