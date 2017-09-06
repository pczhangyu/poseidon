package com.poseidon.web.service.resource.impl;

import com.poseidon.web.mapper.ext.ResourceEntityMapperExt;
import com.poseidon.web.service.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/9/6.
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceEntityMapperExt resourceEntityMapperExt;

    @Override
    public List<Map> queryResourceList() {
        return null;
    }

    @Override
    public List<Map> getAllParentMenus() {
        return null;
    }

    @Override
    public List<Map> getAllChildrenMenus() {
        return null;
    }

    @Override
    public List<Map> getParentMenusByUserId(String userId) {
        return resourceEntityMapperExt.getParentMenusByUserId(userId);
    }

    @Override
    public List<Map> getChildrenMenusByUserId(String userId) {
        return resourceEntityMapperExt.getChildrenMenusByUserId(userId);
    }
}
