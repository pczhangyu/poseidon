package com.poseidon.web.service.role.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.poseidon.common.base.GenerateIDUtil;
import com.poseidon.mapper.RoleEntityMapper;
import com.poseidon.model.ResourceEntity;
import com.poseidon.model.RoleEntity;
import com.poseidon.web.mapper.ext.ResourceEntityMapperExt;
import com.poseidon.web.mapper.ext.RoleEntityMapperExt;
import com.poseidon.web.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by pczhangyu on 2017/9/7.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleEntityMapper roleEntityMapper;

    @Autowired
    RoleEntityMapperExt roleEntityMapperExt;

    @Autowired
    ResourceEntityMapperExt resourceEntityMapperExt;


    @Override
    public PageInfo selectRoleList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        PageInfo pageInfo = new PageInfo(roleEntityMapperExt.getAllRole());
        return  pageInfo;
    }

    @Override
    public RoleEntity selectByRoleId(String roleId) {
        return roleEntityMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void save(RoleEntity model) {
        roleEntityMapper.insertSelective(model);
    }

    @Override
    public void update(RoleEntity model) {
        roleEntityMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public Set<ResourceEntity> loadResources(String roleId) {
        return resourceEntityMapperExt.selectRoleResourcesByRoleId(roleId);
    }

    @Override
    public void updateRoleResources(String roleId, String hidden_ids) {
        // delete old
        roleEntityMapperExt.deleteRoleResourcesByRoleId(roleId);
        // add new
        String[] resources = hidden_ids.split(",");
        for(String resourceId : resources){
            roleEntityMapperExt.insertRoleResources(GenerateIDUtil.getUUID(), roleId, resourceId);
        }
    }

    @Override
    public void enable(String roleId) {
        roleEntityMapperExt.enable(roleId);
    }

    @Override
    public void disable(String roleId) {
        roleEntityMapperExt.disable(roleId);
    }

    @Override
    public RoleEntity selectRoleById(String roleId) {
        return roleEntityMapperExt.selectRoleById(roleId);
    }

    @Override
    public List<String> getResourceByRoleId(String roleId) {
        return resourceEntityMapperExt.resourcesByRoleId(roleId);
    }

    @Override
    public void updateRole(RoleEntity roleEntity, String[] resIds) {
        String roleId = roleEntity.getRoleId();
        roleEntityMapperExt.deleteRoleResourcesByRoleId(roleId);
        for (String resourceId:resIds){
            String uuid = GenerateIDUtil.getUUID();
            roleEntityMapperExt.insertRoleResources(uuid,roleId, resourceId);
        }
    }
}
