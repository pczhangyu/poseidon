package com.poseidon.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.poseidon.base.service.DistrictService;
import com.poseidon.mapper.AreasEntityMapper;
import com.poseidon.mapper.CitiesEntityMapper;
import com.poseidon.mapper.ProvincesEntityMapper;
import com.poseidon.mapper.StreetsEntityMapper;
import com.poseidon.mapper.ext.AreasEntityMapperExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pczhangyu on 2017/8/25.
 */
@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    private AreasEntityMapper areasMapper;

    @Autowired
    private ProvincesEntityMapper provincesMapper;

    @Autowired
    private CitiesEntityMapper citiesMapper;

    @Autowired
    private StreetsEntityMapper streetsMapper;

    @Autowired
    private AreasEntityMapperExt areasMapperExt;

    @Override
    public JSONObject selectAllDistrict() {
        Map<String,Object> objectMap = new HashMap();
        objectMap.put("districts",areasMapperExt.selectAllDistricts());
        return new JSONObject().fluentPutAll(objectMap);
    }
}
