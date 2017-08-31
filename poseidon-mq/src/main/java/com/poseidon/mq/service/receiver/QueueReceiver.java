package com.poseidon.mq.service.receiver;

import com.poseidon.mq.service.constant.QueueConstant;
import com.poseidon.mq.service.enums.QueueEnums;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by pczhangyu on 2017/8/31.
 */
@Component("queueReceiver")
@EnableJms
public class QueueReceiver implements MessageListener,QueueConstant {

    private static Logger logger = LogManager.getLogger(QueueReceiver.class);

    @Override
    @JmsListener(containerFactory = QUEUE_FACTORY,destination = ADD_GOODS_DOC)
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        logger.info(textMessage.toString()+"----------------text");
    }
}

