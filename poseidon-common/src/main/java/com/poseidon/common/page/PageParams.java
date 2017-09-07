package com.poseidon.common.page;

/**
 * Created by FENGCUIJIE on 2017/5/6.
 */
public class PageParams {
    private Integer rows;
    private Integer page;
    //排序字段
    private String sidx;
    //排序方式
    private String sord;

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
