package com.poseidon.admin.controller;

import com.poseidon.web.service.shiro.ShiroUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


/**
 * Created by sunwenming on 2017/4/20.
 */
@Controller
public class LoginController {
    private static Logger logger = LogManager.getLogger(LoginController.class);
    private static final String CHARSET = ";UTF-8";

//    @Autowired
//    private ResourceService resourceService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView toLogin(){
        logger.info("indexController request ");
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView index(){
        Subject user = SecurityUtils.getSubject();
        logger.info("to index");
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    /**
     * 登陆页
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login(){
        logger.info("LoginController request login");
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    /**
     * 登陆认证
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/validate", method = RequestMethod.POST)
    public String validate(String username, String password){
        logger.info("login request json string [{}]", "username:" + username + ",password:" + password);
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            user.login(token);
        } catch (UnknownAccountException e) {
            logger.error("error message : <账号不存在！>[{}]", e.getMessage());
            throw new RuntimeException("账号不存在！", e);
        } catch (DisabledAccountException e) {
            logger.error("error message : <账号未启用！>[{}]", e.getMessage());
            throw new RuntimeException("账号未启用！", e);
        } catch (IncorrectCredentialsException e) {
            logger.error("error message : <密码错误！>[{}]", e.getMessage());
            throw new RuntimeException("密码错误！", e);
        } catch (Throwable e) {
            logger.error("error message : [{}]", e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return "redirect:/home";
    }

    /**
     * home页 或 欢迎页 初始化, 可用于动态更新权限资源后重新加载页面
     * 单一职责原则
     */
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(){
        logger.info("开始加载home页");
        ShiroUser shiroUser =  (ShiroUser) SecurityUtils.getSubject().getPrincipal();
//        List<Map> childrenMenus =  resourceService.getChildrenMenusByUserId(shiroUser.getId());
//        List<Map> parentMenus =  resourceService.getParentMenusByUserId(shiroUser.getId());
        ModelAndView modelAndView = new ModelAndView("home");
//        modelAndView.addObject("childrenMenus", childrenMenus);
//        modelAndView.addObject("parentMenus", parentMenus);
        return modelAndView;
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }

}
