package com.poseidon.admin.controller;

import com.poseidon.model.ResourceEntity;
import com.poseidon.web.service.resource.ResourceService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {
    private static Logger logger = LogManager.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    /**
     * 管理界面
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ModelAndView manager(HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView("resource/resourcelist");
        modelAndView.addObject("targetName",request.getParameter("targetName"));
        modelAndView.addObject("parentName",request.getParameter("parentName"));
        modelAndView.addObject("codeValue","0:ajax,1:form");
        return modelAndView;
    }

    /**
     * 菜单功能管理
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST )
    public @ResponseBody Map list() {
        List<Map> mapList= resourceService.queryResourceList();
        Map map =new HashMap();
        map.put("rows",mapList);
        map.put("total",mapList.size());
        return map;
    }


    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public void saveOrUpdateResource(@ModelAttribute("model") ResourceEntity model, String id, String oper) {
        if("add".equals(oper)){
            logger.info(oper);
            resourceService.saveOrUpdate(model);
        } else if("edit".equals(oper)){
            logger.info(oper);
            model.setSourceId(id);
            resourceService.saveOrUpdate(model);
        } else if("del".equals(oper)){
            logger.info(oper);
            // 逻辑删除
            resourceService.deleteByResourceId(id);
        }
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("resource/add");
        ResourceEntity model = new ResourceEntity();
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    /**
     * 编辑
     */
    @RequestMapping(value = "/{resourceId}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(value = "resourceId") String resourceId) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        ResourceEntity resource = resourceService.selectByResourceId(resourceId);
        modelAndView.addObject("resource", resource);
        return modelAndView;
    }

    /**
     * 启用
     */
    @RequestMapping(value = "/enable/{resourceId}", method = RequestMethod.GET)
    public String enable(@PathVariable(value = "resourceId") String resourceId){
        resourceService.enable(resourceId);
        return "redirect:/resource/list";
    }

    /**
     * 停用
     */
    @RequestMapping(value = "/disable/{resourceId}", method = RequestMethod.GET)
    public String disable(@PathVariable(value = "resourceId") String resourceId){
        resourceService.disable(resourceId);
        return "redirect:/resource/list";
    }

}
