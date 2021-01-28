package com.example.demo.messagequeue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;

import com.alibaba.fastjson.JSONObject;

public class C_005_ActiveMq_Test {

    private static final String PRODUCER_QUEUE_NAME = "EBankSpider_yz";
    private static final String CONSUMER_QUEUE_NAME1 = "paladin-ipo-sh";
    private static final String CONSUMER_QUEUE_NAME2 = "paladin-ipo-sz";

    private static final String BATCH_NO = UUID.randomUUID().toString();

    public static void main(String[] args) throws JMSException {
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
        C_003_ActiveMq_Producer producer = new C_003_ActiveMq_Producer(PRODUCER_QUEUE_NAME);
        producer.produce(getMessageMap("TJBG_SH", "SH"));
        /*int i = 0;
        while(i <= 50) {
            i++;
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            producer.produce(getMessageMap("TRACK_ROBOT_LOG", "SH"));
        }*/
        // 模拟帕拉丁 接收消息
        /*C_004_ActiveMq_Consumer consumer1 = new C_004_ActiveMq_Consumer(PRODUCER_QUEUE_NAME);
        consumer1.getConsumer().setMessageListener(message -> {
            MapMessage mapMessage = (MapMessage) message;
            try {
                System.out.println(mapMessage.getString("logTime") + " " + mapMessage.getString("logInfo"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
    }

    private static Map<String, String> getMessageMap(String key, String market) {
        Map<String, String> map = new HashMap<>();
        switch (key) {
            case "TEST_HEARTBEAT":
                map.put("type", key);
                map.put("market", market);
                map.put("mongoStatus", "true");
                map.put("sharkDiskStatus", "true");
                break;
            case "TRACK_ROBOT_LOG":
                map.put("type", key);
                map.put("batchNo", BATCH_NO);
                map.put("market", market);
                map.put("bizType", "0");
                map.put("secCode", "123456");
                map.put("logTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
                map.put("logInfo", "日志" + UUID.randomUUID().toString());
                map.put("success", "true");
                break;
            case "REPORT_STATUS":
                map.put("type", key);
                map.put("market", market);
                map.put("secCode", "605009");
                map.put("reportStatus", "9");
                map.put("reportType", "0");
                break;
            case "TJBG_SH":
                map.put("fileType", "TJBG_SH");
                map.put("market", market);
                map.put("fileUrl", "D:\\shareDisk\\688185投资价值报告.pdf");
                map.put("secCode", "688185");
                map.put("batchNo", "999999999");
                break;
        }
        return map;
    }

    private static Map<String, String> testReport() {
        QuoteParam quoteParam = new QuoteParam();
        quoteParam.setAutoSubmit("0");
        quoteParam.setImportType("1");
        quoteParam.setCode("123456");
        quoteParam.setName("123456");
        quoteParam.setMarket("SH");
        quoteParam.setType("10");
        //记录上报操作id
        quoteParam.setMessageId("");
        Map<String, Object> sendMap = new HashMap<>();
        sendMap.put("importQuoteInfo", quoteParam);
        Map<String, String> map = new HashMap<>();
        map.put("uploadJson", new JSONObject(sendMap).toJSONString());
        return map;
    }

    static class QuoteParam {
        private String code;
        private String name;
        private String market;
        private String type;
        private String filePath;
        private Double price;
        private String offerBase;
        private String operator;
        private String contactNumber;
        private String mobilePhone;
        private String email;
        private String efax;
        private List<IpoFund> funds;
        private String importType;
        private String autoSubmit;
        private String md5;
        private String messageId;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMarket() {
            return market;
        }

        public void setMarket(String market) {
            this.market = market;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getOfferBase() {
            return offerBase;
        }

        public void setOfferBase(String offerBase) {
            this.offerBase = offerBase;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEfax() {
            return efax;
        }

        public void setEfax(String efax) {
            this.efax = efax;
        }

        public String getImportType() {
            return importType;
        }

        public void setImportType(String importType) {
            this.importType = importType;
        }

        public String getAutoSubmit() {
            return autoSubmit;
        }

        public void setAutoSubmit(String autoSubmit) {
            this.autoSubmit = autoSubmit;
        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public List<IpoFund> getFunds() {
            return funds;
        }

        public void setFunds(List<IpoFund> funds) {
            this.funds = funds;
        }
    }

    static class IpoFund {
        private String fundName;
        private double price;
        private double volume;
        private int lockupPeriod;

        public String getFundName() {
            return fundName;
        }

        public void setFundName(String fundName) {
            this.fundName = fundName;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getVolume() {
            return volume;
        }

        public void setVolume(double volume) {
            this.volume = volume;
        }

        public int getLockupPeriod() {
            return lockupPeriod;
        }

        public void setLockupPeriod(int lockupPeriod) {
            this.lockupPeriod = lockupPeriod;
        }

    }
}
