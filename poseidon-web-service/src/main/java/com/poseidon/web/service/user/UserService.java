package com.poseidon.web.service.user;


import com.poseidon.model.RoleEntity;
import com.poseidon.model.UserEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pczhangyu on 2017/9/5.
 */

public interface UserService {

    UserEntity selectByLoginName(String loginName);

    List<Map<String,Object>> getUserWithRoleAndResource(String loginName);

    List<UserEntity> getAllUser();

    UserEntity selectByUserId(String userId);

    Set<RoleEntity> loadRoles(String userId);

    void save(UserEntity entity);

    void update(UserEntity entity);

    void updateUserRoles(String userId, String hidden_ids);

    void enable(String userId);

    void disable(String userId);
}
