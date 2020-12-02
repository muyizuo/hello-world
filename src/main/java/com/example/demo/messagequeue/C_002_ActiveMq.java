package com.example.demo.messagequeue;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 */
public class C_002_ActiveMq {

    private static final String ACTIVEMQ_URL = "tcp://192.168.72.93:61616";

    private static final String USER_NAME = "activemq1";

    private static final String PASSWORD = "activemq1";

    private static Connection connection;

    protected Session session;

    protected Destination destination;

    static {
        // 创建连接
        try {
            // 创建连接工厂
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            connection = activeMQConnectionFactory.createConnection(USER_NAME, PASSWORD);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    protected void initMq(String queueName) throws JMSException {
        // 打开连接
        connection.start();
        // 创建会话
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列目标,并标识队列名称，消费者根据队列名称接收数据
        destination = session.createQueue(queueName);
    }
}
