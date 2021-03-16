package com.example.demo.messagequeue.activemq;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.jms.JMSException;
import javax.jms.MapMessage;

import com.alibaba.fastjson.JSONObject;

public class C_005_ActiveMq_Test {

    private static final String PRODUCER_QUEUE_NAME1 = "EBankSpider_yz";
    private static final String PRODUCER_QUEUE_NAME2 = "paladinBk";
    private static final String CONSUMER_QUEUE_NAME1 = "paladin-ipo-sh";
    private static final String CONSUMER_QUEUE_NAME2 = "paladin-ipo-sz";

    public static void main(String[] args) throws JMSException {
        // 发送消息
        C_003_ActiveMq_Producer producer = new C_003_ActiveMq_Producer(PRODUCER_QUEUE_NAME2);
        Map<String, String> msg = new HashMap<>();
        msg.put("shibor", "{ \"shibor\" : \"shibor\" }");
        producer.produce(msg);
        // 模拟上交所机器人 接收消息并回复
        /*C_004_ActiveMq_Consumer consumer1 = new C_004_ActiveMq_Consumer(CONSUMER_QUEUE_NAME1);
        consumer1.getConsumer().setMessageListener(message -> {
            MapMessage mapMessage = (MapMessage) message;
            try {
                String uploadJson = mapMessage.getString("uploadJson");
                System.out.println(uploadJson);
                JSONObject object = JSONObject.parseObject(uploadJson);
                String key = object.keySet().stream().findFirst().get();
                String market = object.getJSONObject(key).getString("market");

                TimeUnit.SECONDS.sleep(3);

                C_003_ActiveMq_Producer producer = new C_003_ActiveMq_Producer(PRODUCER_QUEUE_NAME);
                producer.produce(getMessageMap(key, market));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
        // 模拟深交所机器人 接收消息并回复
        /*C_004_ActiveMq_Consumer consumer2 = new C_004_ActiveMq_Consumer(CONSUMER_QUEUE_NAME2);
        consumer2.getConsumer().setMessageListener(message -> {
            MapMessage mapMessage = (MapMessage) message;
            try {
                String uploadJson = mapMessage.getString("uploadJson");
                System.out.println(uploadJson);
                JSONObject object = JSONObject.parseObject(uploadJson);
                String key = object.keySet().stream().findFirst().get();
                String market = object.getJSONObject(key).getString("market");

                TimeUnit.SECONDS.sleep(3);

                C_003_ActiveMq_Producer producer = new C_003_ActiveMq_Producer(PRODUCER_QUEUE_NAME);
                producer.produce(getMessageMap(key, market));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
        // 模拟机器人 直接发送消息
        /*C_003_ActiveMq_Producer producer = new C_003_ActiveMq_Producer(PRODUCER_QUEUE_NAME);
        producer.produce(getMessageMap("TJBG_SH", "SH"));*/
    }
}
