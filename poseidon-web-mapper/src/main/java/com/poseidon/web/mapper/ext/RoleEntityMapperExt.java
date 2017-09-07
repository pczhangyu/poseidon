package com.poseidon.web.mapper.ext;


import com.poseidon.model.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleEntityMapperExt {

    List<RoleEntity> getAllRole();

    Set<RoleEntity> selectUserRolesByUserId(@Param("userId") String userId);

    void deleteRoleResourcesByRoleId(@Param("roleId") String roleId);

    void insertRoleResources(@Param("uuid") String uuid, @Param("roleId") String roleId, @Param("resourceId") String resourceId);

    void enable(@Param("roleId") String roleId);

    void disable(@Param("roleId") String roleId);
    RoleEntity selectRoleById(@Param("roleId") String roleId);

}