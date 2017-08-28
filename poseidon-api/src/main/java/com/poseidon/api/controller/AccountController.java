package com.poseidon.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.poseidon.base.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pczhangyu on 2017/8/25.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping(value = "/info",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JSONObject getMemberInfoById(@RequestBody JSONObject jsonObject){
        return new JSONObject().fluentPut("test","testObject");
    }

    @RequestMapping(value = "/get/districts",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JSONObject getAllDistricts(@RequestBody JSONObject jsonObject){
        return districtService.selectAllDistrict();
    }

}
