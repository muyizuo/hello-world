package com.example.demo.messagequeue.activemq;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;

public class C_004_ActiveMq_Consumer extends C_002_ActiveMq {

    private MessageConsumer consumer;

    public C_004_ActiveMq_Consumer(String queueName) throws JMSException {
        initMq(queueName);
        // 创建消费者
        this.consumer = session.createConsumer(destination);
    }

    public MessageConsumer getConsumer() {
        return consumer;
    }
}
