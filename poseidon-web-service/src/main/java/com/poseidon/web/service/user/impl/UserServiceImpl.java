package com.poseidon.web.service.user.impl;

import com.poseidon.model.UserEntity;
import com.poseidon.web.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/9/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService{


    @Override
    public UserEntity selectByLoginName(String loginName) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getUserWithRoleAndResource(String loginName) {
        return null;
    }
}
