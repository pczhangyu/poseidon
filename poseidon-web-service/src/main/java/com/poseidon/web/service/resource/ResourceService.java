package com.poseidon.web.service.resource;

import com.poseidon.model.ResourceEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/9/6.
 */
public interface ResourceService {

    List<Map> queryResourceList();

    List<Map> getAllParentMenus();

    List<Map> getAllChildrenMenus();

    List<Map> getParentMenusByUserId(String userId);

    List<Map> getChildrenMenusByUserId(String userId);

    void disable(String resourceId);

    void enable(String resourceId);

    void saveOrUpdate (ResourceEntity model);

    void save(ResourceEntity model);

    void update(ResourceEntity model);

    ResourceEntity selectByResourceId(String resourceId);

    void deleteByResourceId(String resourceId);
}
