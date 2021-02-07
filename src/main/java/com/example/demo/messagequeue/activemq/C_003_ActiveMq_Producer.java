package com.example.demo.messagequeue.activemq;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;

public class C_003_ActiveMq_Producer extends C_002_ActiveMq {

    private MessageProducer producer;

    public C_003_ActiveMq_Producer(String queueName) throws JMSException {
        super.initMq(queueName);
        // 创建一个生产者
        producer = session.createProducer(destination);
    }

    /**
     * 发送消息
     *
     * @param map
     * @throws JMSException
     */
    private void send(Map<String, String> map) throws JMSException {
        MapMessage mapMessage = session.createMapMessage();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            mapMessage.setString(entry.getKey(), entry.getValue());
        }
        producer.send(mapMessage);
    }

    public void produce(Map<String, String> map) {
        try {
            send(map);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
