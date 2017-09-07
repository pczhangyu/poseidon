package com.poseidon.web.service.role;

import com.github.pagehelper.PageInfo;
import com.poseidon.model.ResourceEntity;
import com.poseidon.model.RoleEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by pczhangyu on 2017/9/7.
 */
public interface RoleService {

    PageInfo selectRoleList(Integer page , Integer pageSize);

    RoleEntity selectByRoleId(String roleId);

    void save(RoleEntity model);

    void update(RoleEntity model);

    Set<ResourceEntity> loadResources(String roleId);

    void updateRoleResources(String roleId, String hidden_ids);

    void enable(String roleId);

    void disable(String roleId);

    RoleEntity selectRoleById(String roleId);

    List<String> getResourceByRoleId(String roleId);

    void updateRole(RoleEntity roleEntity, String[] resIds);
}
