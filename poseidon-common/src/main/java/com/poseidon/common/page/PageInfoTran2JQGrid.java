package com.poseidon.common.page;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FENGCUIJIE on 2017/5/6.
 */
public class PageInfoTran2JQGrid {

        /**
         *
         * @param pageInfo
         * @return
         */
        public static Map pageInfoToResult(PageInfo pageInfo){
            Map<String,Object> result=new HashMap<String, Object>();
            result.put("total",pageInfo.getPages());//总页数
            result.put("page",pageInfo.getPageNum());//当前页
            result.put("records",pageInfo.getTotal());//查询出来的记录数
            result.put("rows",pageInfo.getList());//数据
            return result;
        }
}
