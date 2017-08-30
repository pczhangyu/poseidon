package com.poseidon.search.enums;

/**
 * Created by pczhangyu on 2017/8/29.
 */
public enum  ElasticIndexEnum {

    GOODS_INFO("goods","info"),
    GOODS_LIST("goods","list");

    private String indexType;

    private String indexName;


    ElasticIndexEnum(String indexName, String indexType) {
        this.indexName=indexName;
        this.indexType=indexType;
    }


    public String getIndexType() {
        return indexType;
    }

    public String getIndexName() {
        return indexName;
    }

}

class test{
    public static void main(String[] args) {
        System.out.println(ElasticIndexEnum.GOODS_INFO.getIndexType());
    }
}
