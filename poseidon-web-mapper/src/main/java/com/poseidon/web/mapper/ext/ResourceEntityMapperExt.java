package com.poseidon.web.mapper.ext;

import com.poseidon.model.ResourceEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by pczhangyu on 2017/9/6.
 */
public interface ResourceEntityMapperExt {

    List<ResourceEntity> getAllResource();

    Set<ResourceEntity> selectRoleResourcesByRoleId(@Param("roleId") String roleId);

    void disable(@Param("resourceId") String resourceId);

    void enable(@Param("resourceId") String resourceId);

    List<Map> getParentMenusByUserId(@Param("userId") String userId);

    List<Map> getChildrenMenusByUserId(@Param("userId") String userId);

    List<Map> getAllParentMenus();

    List<Map> getAllChildrenMenus();

    List<Map> queryResourceList();

    void deleteByResourceId(@Param("resourceId")String resourceId);

    List<String> resourcesByRoleId(@Param("roleId") String roleId);

    List<Map> getAllChildrenMenusBySourceId(@Param("sourceId")String sourceId);
}
