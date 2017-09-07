package com.poseidon.web.service.resource.impl;

import com.poseidon.common.base.GenerateIDUtil;
import com.poseidon.mapper.ResourceEntityMapper;
import com.poseidon.model.ResourceEntity;
import com.poseidon.web.mapper.ext.ResourceEntityMapperExt;
import com.poseidon.web.service.resource.ResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/9/6.
 */
@Service("resourceService")
public class ResourceServiceImpl implements ResourceService{

    @Autowired
    private ResourceEntityMapper resourceEntityMapper;

    @Autowired
    private ResourceEntityMapperExt resourceEntityMapperExt;

    @Override
    public List<Map> queryResourceList() {
        //取出所有一级菜单列表
        List<Map> maps = resourceEntityMapperExt.getAllParentMenus();
        //创建一个集合用来存放所有的菜单
        List<Map> mapList = new ArrayList<Map>();
        //遍历一级菜单
        for (Map map :maps){
            map.put("expanded",true);
            map.put("isLeaf",false);
            mapList.add(map);
            //取出对应一级菜单下的所有二级菜单
            List<Map> childList =resourceEntityMapperExt.getAllChildrenMenusBySourceId(String.valueOf(map.get("sourceId")));
            if (childList == null || childList.size() == 0){
                map.put("isLeaf",true);
            }
            if (childList != null && childList.size() > 0){
                for (Map map1 :childList){
                    map1.put("expanded",true);
                    map1.put("isLeaf",false);
                    map1.put("level",1);
                    mapList.add(map1);
                    //取出二级菜单下的功能列表
                    List<Map> childList2 =resourceEntityMapperExt.getAllChildrenMenusBySourceId(String.valueOf(map1.get("sourceId")));
                    if (childList2 == null || childList2.size() == 0){
                        map1.put("isLeaf",true);
                    }
                    if (childList2 != null && childList2.size() > 0){
                        for (Map map2 :childList2){
                            map2.put("expanded",true);
                            map2.put("isLeaf",true);
                            map2.put("level",2);
                            mapList.add(map2);
                        }
                    }
                }
            }

        }
        return mapList;
    }

    @Override
    public List<Map> getAllParentMenus() {
        return resourceEntityMapperExt.getAllParentMenus();
    }

    @Override
    public List<Map> getAllChildrenMenus() {
        return resourceEntityMapperExt.getAllChildrenMenus();
    }

    @Override
    public List<Map> getParentMenusByUserId(String userId) {
        return resourceEntityMapperExt.getParentMenusByUserId(userId);
    }

    @Override
    public List<Map> getChildrenMenusByUserId(String userId) {
        return resourceEntityMapperExt.getChildrenMenusByUserId(userId);
    }

    @Override
    public void disable(String resourceId) {
        resourceEntityMapperExt.disable(resourceId);
    }

    @Override
    public void enable(String resourceId) {
        resourceEntityMapperExt.enable(resourceId);
    }

    @Override
    public void saveOrUpdate(ResourceEntity model) {
        if(StringUtils.isBlank(model.getSourceId())){
            model.setSourceId(GenerateIDUtil.getUUID());
            model.setCreateTime(new Date());
            model.setUrl(model.getSourceUrl());
            this.save(model);
        } else {
            this.update(model);
        }
    }

    @Override
    public void save(ResourceEntity model) {
        resourceEntityMapper.insertSelective(model);
    }

    @Override
    public void update(ResourceEntity model) {
        resourceEntityMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    public ResourceEntity selectByResourceId(String resourceId) {
        return resourceEntityMapper.selectByPrimaryKey(resourceId);
    }

    @Override
    public void deleteByResourceId(String resourceId) {

    }
}
