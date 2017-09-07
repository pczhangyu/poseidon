package com.poseidon.admin.controller;

import com.github.pagehelper.PageInfo;
import com.poseidon.common.page.PageInfoTran2JQGrid;
import com.poseidon.common.page.PageParams;
import com.poseidon.model.ResourceEntity;
import com.poseidon.model.RoleEntity;
import com.poseidon.web.service.resource.ResourceService;
import com.poseidon.web.service.role.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    private static Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView manager(HttpServletRequest request) {
        request.getParameter("targetName");
        request.getParameter("parentName");
        ModelAndView modelAndView = new ModelAndView("role/rolelist");
        modelAndView.addObject("targetName",request.getParameter("targetName"));
        modelAndView.addObject("parentName",request.getParameter("parentName"));
        return modelAndView;
    }

    /**
     * 角色列表
     * @param pageParams
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody
    Map list(PageParams pageParams) {
        PageInfo pageInfo = roleService.selectRoleList(pageParams.getPage(),pageParams.getRows());
        Map map = PageInfoTran2JQGrid.pageInfoToResult(pageInfo);
        return map;
    }

    /**
     * 根据角色id获取当前角色已拥有的资源
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/rolesource", method = RequestMethod.POST)
    @ResponseBody
    public List<Map> getRoleResource(String roleId){
        //根据用户角色取出该用户已经拥有的资源
        List<String> list= roleService.getResourceByRoleId(roleId);
        Map<String,Object> resourceIdMap = new HashMap<String, Object>();
        for (String resourceId : list){
            resourceIdMap.put(resourceId,"resourceId");
        }
        //取出所有的二级菜单
        List<Map> childrenMenus =  resourceService.getAllChildrenMenus();
        //取出所有的一级菜单
        List<Map> parentMenus =  resourceService.getAllParentMenus();
        //遍历所有一级菜单生成前台插件treeview所需要的数据格式
        //所需格式为
        //[
        // {text:parent1,
        //  nodes:[
        //      {text:children1}
        //     ]
        // }]
        List<Map> allList = new LinkedList<Map>();
        if (parentMenus != null){
            for (Map parentsMap :parentMenus){
                Map firstMap = new HashMap();
                firstMap.put("text",parentsMap.get("sourceName"));
                firstMap.put("selectable",false);
                firstMap.put("sourceId",parentsMap.get("sourceId"));
                    if (resourceIdMap.get(parentsMap.get("sourceId")) != null && resourceIdMap.get(parentsMap.get("sourceId")) !=""){
                        Map checkedMap = new HashMap();
                        checkedMap.put("checked",true);
                        firstMap.put("state",checkedMap);
                    }
                allList.add(firstMap);
            }
        }
        //遍历所有二级菜单生成前台插件treeview所需要的数据格式，并放到对应的父菜单下
        if (childrenMenus !=null){
            for (Map map : allList){
                List<Map> nodesList = new LinkedList<Map>();
                for (Map childMap : childrenMenus){
                    if (childMap.get("pid").equals(map.get("sourceId"))){
                        Map firstMap = new HashMap();
                        firstMap.put("text",childMap.get("sourceName"));
                        firstMap.put("selectable",false);
                        firstMap.put("sourceId",childMap.get("sourceId"));
                        if (resourceIdMap.get(childMap.get("sourceId")) != null && resourceIdMap.get(childMap.get("sourceId")) !=""){
                                Map checkedMap = new HashMap();
                                checkedMap.put("checked",true);
                                firstMap.put("state",checkedMap);
                        }
                        nodesList.add(firstMap);
                    }
                }
                map.put("nodes",nodesList);
            }
        }

        return allList;
    }

    /**
     * 更新角色和为角色分配资源
     * @param roleEntity
     * @param resIds
     * @return
     */
    @RequestMapping(value = "/roleWithSource", method = RequestMethod.POST)
    @ResponseBody
    public String roleWithSource(RoleEntity roleEntity, @RequestParam("resIds[]") String[] resIds){
        roleService.updateRole(roleEntity,resIds);
        return "success";
    }

    /**
     * 获取指定角色
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/distribution/{roleId}", method = RequestMethod.GET)
    public ModelAndView andDistributionView(@PathVariable String roleId) {
        ModelAndView modelAndView = new ModelAndView("role/distribution");
        RoleEntity model =roleService.selectRoleById(roleId);
        modelAndView.addObject("model",model);
        return modelAndView;
    }
    /**
     * 添加
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("role/add");
        RoleEntity model = new RoleEntity();
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    /**
     * 编辑
     */
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "roleId") String roleId) {
        ModelAndView modelAndView = new ModelAndView("role/edit");
        RoleEntity model = roleService.selectByRoleId(roleId);
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public String saveOrUpdate(@ModelAttribute("model") RoleEntity model) {
        if(StringUtils.isBlank(model.getRoleId())){
            roleService.save(model);
        } else {
            roleService.update(model);
        }
        return "redirect:/role/list";
    }

    /**
     * 加载资源
     */
    @RequestMapping(value = "/{roleId}/resources", method = RequestMethod.GET)
    public ModelAndView resources(@PathVariable(value = "roleId") String roleId) {
        ModelAndView modelAndView = new ModelAndView();
        Set<ResourceEntity> resources = roleService.loadResources(roleId);
        modelAndView.addObject("resources", resources);
        return modelAndView;
    }


    /**
     * 编辑资源
     */
    @RequestMapping(value = "/{roleId}/resources/edit", method = RequestMethod.POST)
    public String resources_edit(@PathVariable(value = "roleId") String roleId, String hidden_ids) {
        roleService.updateRoleResources(roleId, hidden_ids);
        return "redirect:/role/" + roleId;
    }


    /**
     * 启用
     */
    @RequestMapping(value = "/enable/{roleId}", method = RequestMethod.GET)
    public String enable(@PathVariable(value = "roleId") String roleId){
        roleService.enable(roleId);
        return "redirect:/role/list";
    }

    /**
     * 停用
     */
    @RequestMapping(value = "/disable/{roleId}", method = RequestMethod.GET)
    public String disable(@PathVariable(value = "roleId") String roleId){
        roleService.disable(roleId);
        return "redirect:/role/list";
    }

    /**
     * 停用
     */
    @RequestMapping(value = "/distribution", method = RequestMethod.GET)
    public ModelAndView distribution(){
        ModelAndView modelAndView = new ModelAndView("role/distribution");

        return modelAndView;
    }
}
