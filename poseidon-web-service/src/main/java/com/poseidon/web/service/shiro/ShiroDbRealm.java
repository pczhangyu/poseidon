package com.poseidon.web.service.shiro;

import com.alibaba.fastjson.JSON;
import com.frigga.model.UserEntity;
import com.poseidon.web.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm {
    private static final Logger logger = LogManager.getLogger(ShiroDbRealm.class);

    @Autowired
    private UserService userService;
    @Autowired

    public ShiroDbRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }

    /**
     * Shiro登录认证
     * (原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm  通过用户名将密码查询返回 ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制 )
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("Shiro开始登录认证");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        if(StringUtils.isNotBlank(username)){
            UserEntity user = userService.selectByLoginName(username);
            logger.debug(JSON.toJSONString(user));

            if(user != null){
                List<Map<String,Object>> userInfoList = userService.getUserWithRoleAndResource(user.getLoginName());
                Set<String> roles = new HashSet<String>();
                Set<String> urls = new HashSet<String>();
                for (Map<String, Object> stringObjectMap : userInfoList) {
                   urls.add((String)stringObjectMap.get("url"));
                    roles.add((String)stringObjectMap.get("roleName"));
                }
                ShiroUser shiroUser = new ShiroUser(user.getUserId(), user.getLoginName(), user.getCnName(), urls,roles);
                return new SimpleAuthenticationInfo(shiroUser, user.getPassWord().toCharArray(), ShiroByteSource.of(user.getSalt()), this.getName());
            }
        }
        return null;
    }

    /**
     * Shiro权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(shiroUser.getRoles());
        info.addStringPermissions(shiroUser.getUrlSet());
        return info;
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
        UserEntity userEntity = (UserEntity) principals.getPrimaryPrincipal();
        removeUserCache(userEntity);
    }

    /**
     * 清除用户缓存
     * @param userEntity
     */
    public void removeUserCache(UserEntity userEntity){
        removeUserCache(userEntity.getLoginName());
    }

    /**
     * 清除用户缓存
     * @param loginName
     */
    public void removeUserCache(String loginName){
        SimplePrincipalCollection principals = new SimplePrincipalCollection();
        principals.add(loginName, super.getName());
        super.clearCachedAuthenticationInfo(principals);
    }
}
