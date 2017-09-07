package com.poseidon.web.service.user.impl;

import com.poseidon.common.base.GenerateIDUtil;
import com.poseidon.mapper.RoleEntityMapper;
import com.poseidon.mapper.UserEntityMapper;
import com.poseidon.model.RoleEntity;
import com.poseidon.model.UserEntity;
import com.poseidon.web.mapper.ext.RoleEntityMapperExt;
import com.poseidon.web.mapper.ext.UserEntityMapperExt;
import com.poseidon.web.service.shiro.PasswordHash;
import com.poseidon.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pczhangyu on 2017/9/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private UserEntityMapperExt userEntityMapperExt;

    @Autowired
    private RoleEntityMapperExt roleEntityMapperExt;

    @Autowired
    private PasswordHash passwordHash;

    @Override
    public UserEntity selectByLoginName(String loginName) {
        return userEntityMapperExt.selectByLoginName(loginName);
    }

    @Override
    public List<Map<String, Object>> getUserWithRoleAndResource(String loginName) {
        return userEntityMapperExt.getUserWithRoleAndResource(loginName);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userEntityMapperExt.getAllUser();
    }

    @Override
    public UserEntity selectByUserId(String userId) {
        return userEntityMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Set<RoleEntity> loadRoles(String userId) {
        return roleEntityMapperExt.selectUserRolesByUserId(userId);
    }

    @Override
    public void save(UserEntity model) {
        model.setUserId(GenerateIDUtil.getUUID());
        //FIXME 是否有删除状态?
        model.setUserStatus((byte) 0);
        model.setCreateTime(new Date());
        //FIXME 加密盐是否是固定的
        model.setSalt("salt");
        model.setPassWord(passwordHash.toHex(model.getPassWord(), model.getSalt()));
        userEntityMapper.insertSelective(model);
    }

    @Override
    public void update(UserEntity entity) {
        userEntityMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public void updateUserRoles(String userId, String hidden_ids) {
        // delete old
        userEntityMapperExt.deleteUserRolesByUserId(userId);
        // add new
        String[] roles = hidden_ids.split(",");
        for(String roleId : roles){
            userEntityMapperExt.insertUserRoles(GenerateIDUtil.getUUID(), userId, roleId);
        }
    }

    @Override
    public void enable(String userId) {
        roleEntityMapperExt.enable(userId);
    }

    @Override
    public void disable(String userId) {

    }
}
