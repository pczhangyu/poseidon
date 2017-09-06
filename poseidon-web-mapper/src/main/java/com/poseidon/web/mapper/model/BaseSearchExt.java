package com.poseidon.web.mapper.model;

/**
 */
public class BaseSearchExt {

    /** 页码 */
    private Integer pageNum;

    /** 定量 */
    private Integer pageSize;


//***********************************	getter and setter	*************************************//

    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum == null ? 1 : pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize == null ? 15 : pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
