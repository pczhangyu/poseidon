package com.poseidon.mq.service.enums;

/**
 * Created by pczhangyu on 2017/8/31.
 */
public enum  QueueEnums {
    ADD_GOODS_INDEX("goods","add_goods_doc");

    QueueEnums(String type, String action) {
        this.queueType=type;
        this.queueAction=action;
    }

    private String queueType;

    private String queueAction;

    public String getQueueType() {
        return queueType;
    }

    public String getQueueAction() {
        return queueAction;
    }

}

