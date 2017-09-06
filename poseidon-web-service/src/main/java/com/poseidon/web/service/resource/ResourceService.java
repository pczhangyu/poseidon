package com.poseidon.web.service.resource;

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

//    ResourceEntity selectByResourceId
}
