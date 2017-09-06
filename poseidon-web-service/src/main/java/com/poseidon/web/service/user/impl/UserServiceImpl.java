package com.poseidon.web.service.user.impl;

import com.poseidon.mapper.UserEntityMapper;
import com.poseidon.model.UserEntity;
import com.poseidon.web.mapper.ext.UserEntityMapperExt;
import com.poseidon.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/9/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private UserEntityMapperExt userEntityMapperExt;

    @Override
    public UserEntity selectByLoginName(String loginName) {
        return userEntityMapperExt.selectByLoginName(loginName);
    }

    @Override
    public List<Map<String, Object>> getUserWithRoleAndResource(String loginName) {
        return userEntityMapperExt.getUserWithRoleAndResource(loginName);
    }
}
