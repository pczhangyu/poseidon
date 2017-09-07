package com.poseidon.admin.controller;

import com.google.common.base.Strings;
import com.poseidon.common.base.GenerateIDUtil;
import com.poseidon.model.RoleEntity;
import com.poseidon.model.UserEntity;
import com.poseidon.web.service.user.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

/**
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private UserService userService;


    /**
     * 列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("user/list");
        List<UserEntity> userEntityList = userService.getAllUser();
        modelAndView.addObject("users", userEntityList);
        return modelAndView;
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("user/add");
        UserEntity model = new UserEntity();
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    /**
     * 编辑
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "userId") String userId) {
        ModelAndView modelAndView = new ModelAndView("user/edit");
        UserEntity model = userService.selectByUserId(userId);
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("model") UserEntity model) {
        if(Strings.isNullOrEmpty(model.getUserId())){
            model.setUserId(GenerateIDUtil.getUUID());
            userService.save(model);
        } else {
            userService.update(model);
        }
        return "redirect:/user/list";
    }

    /**
     * 加载角色
     */
    @RequestMapping(value = "/{userId}/roles", method = RequestMethod.GET)
    public ModelAndView roles(@PathVariable(value = "userId") String userId) {
        ModelAndView modelAndView = new ModelAndView();
        Set<RoleEntity> roles = userService.loadRoles(userId);
        modelAndView.addObject("roles", roles);
        return modelAndView;
    }

    /**
     * 编辑角色
     */
    @RequestMapping(value = "/{userId}/roles/edit", method = RequestMethod.POST)
    public String roles_edit(@PathVariable(value = "userId") String userId, String hidden_ids) {
        userService.updateUserRoles(userId, hidden_ids);
        return "redirect:/user/" + userId;
    }

    /**
     * 启用
     */
    @RequestMapping(value = "/enable/{userId}", method = RequestMethod.GET)
    public String enable(@PathVariable(value = "userId") String userId){
        userService.enable(userId);
        return "redirect:/user/list";
    }

    /**
     * 停用
     */
    @RequestMapping(value = "/disable/{userId}", method = RequestMethod.GET)
    public String disable(@PathVariable(value = "userId") String userId){
        userService.disable(userId);
        return "redirect:/user/list";
    }

}
