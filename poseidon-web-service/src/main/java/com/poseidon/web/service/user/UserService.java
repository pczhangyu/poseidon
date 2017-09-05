package com.poseidon.web.service.user;


import com.poseidon.model.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/9/5.
 */

public interface UserService {

    UserEntity selectByLoginName(String loginName);

    List<Map<String,Object>> getUserWithRoleAndResource(String loginName);

}
