package com.poseidon.web.mapper.ext;


import com.poseidon.model.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserEntityMapperExt {

    UserEntity selectByLoginName(@Param("loginName") String loginName);

    List<Map<String,Object>> getUserWithRoleAndResource(@Param("loginName") String loginName);

    List<UserEntity> getAllUser();

    void insertUserRoles(@Param("uuid") String uuid, @Param("userId") String userId, @Param("roleId") String roleId);

    void deleteUserRolesByUserId(@Param("userId") String userId);

    void enable(@Param("userId") String userId);

    void disable(@Param("userId") String userId);

}