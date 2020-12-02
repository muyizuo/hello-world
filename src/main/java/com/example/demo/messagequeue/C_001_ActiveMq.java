package com.example.demo.messagequeue;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * ActiveMq练习使用
 *
 * 1.消息中间件：两个系统或者两个客户端之间进行消息传送的通道
 * 2.ActiveMQ是一种开源的基于JMS（Java Message Servie）规范的一种消息中间件的实现，
 *   ActiveMQ的设计目标是提供标准的，面向消息的，能够跨越多语言和多系统的应用集成消息通信中间件。
 * 3.ActiveMQ常被应用与系统业务的解耦，异步消息的推送，增加系统并发量，提高用户体验。
 * 4.ActiveMQ的数据传送流程：Producer -> broke -> Consumer
 *   生产者推送消息至broke队列，消息者从broke队列中获取消息进行消费。
 * 5.ActiveMQ的两种消息传输类型：
 *   （1）“点对点传输”，即一个生产者对应一个消费者，生产者向broke推送数据，数据存储在broke的一个队列中，当消费者接受该条队列里的数据。
 *   （2）“基于发布/订阅模式的传输”，即根据订阅话题来接收相应数据，一个生产者可向多个消费者推送数据
 *
 *
 */
public class C_001_ActiveMq {

    private static final String ACTIVEMQ_URL = "tcp://192.168.72.93:61616";

    private static final String USER_NAME = "activemq1";

    private static final String PASSWORD = "activemq1";

    private static final String QUEUE_NAME = "AmyQueue";

    public static void main(String[] args) throws JMSException {
        produce();

        consume();
    }

    /**
     * 生产者 发送消息
     *
     * @throws JMSException
     */
    public static void produce() throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection(USER_NAME, PASSWORD);
        // 打开连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列目标,并标识队列名称，消费者根据队列名称接收数据
        Destination destination = session.createQueue(QUEUE_NAME);
        // 创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        // 向队列推送10个文本消息数据
        for (int i = 1 ; i <= 10 ; i++){
            // 创建文本消息
            TextMessage message = session.createTextMessage("第" + i + "个文本消息");
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("已发送的消息：" + message.getText());
        }
        //关闭连接
        connection.close();
    }

    /**
     * 消费者 发送消息
     *
     * @throws JMSException
     */
    public static void consume() throws JMSException {
        // 创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // 创建连接
        Connection connection = activeMQConnectionFactory.createConnection(USER_NAME, PASSWORD);
        // 打开连接
        connection.start();
        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 创建队列目标,并标识队列名称，消费者根据队列名称接收数据
        Destination destination = session.createQueue(QUEUE_NAME);
        // 创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        // 创建消费的监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费的消息：" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
