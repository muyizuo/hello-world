package com.example.demo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 使用mongodb驱动连接（注意驱动包是mongo-java-driver，而不是mongodb-driver）
 * @Author: yz
 * @Date: 2020/12/17 14:25
 */
public class C_001_MongoDb {

    private static final String HOST = "192.168.72.93";
    private static final int POST = 27017;
    private static final String USERNAME = "pldTask";
    private static final String PASSWORD = "pldTask";
    private static final String DB_NAME = "paladin_task_log";
    private static final String COLLECTION_NAME = "IPO_MONITOR_LOG";

    public static void main(String[] args) {
        // loginWithPsw();
        // loginNoPsw();
    }

    private static void loginWithPsw() {
        //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
        //ServerAddress()两个参数分别为 服务器地址 和 端口
        ServerAddress serverAddress = new ServerAddress(HOST, POST);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createCredential(USERNAME, DB_NAME, PASSWORD.toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(serverAddress, credentials);

        //连接到数据库
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);
        System.out.println("Connect to database successfully");

        // 获取集合
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        FindIterable<Document> documents = collection.find();

        MongoCursor<Document> iterator = documents.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }


    private static void loginNoPsw() {
        // 连接到MongoDB服务
        MongoClient mongoClient = new MongoClient(HOST);

        // 连接到数据库
        MongoDatabase database = mongoClient.getDatabase(DB_NAME);

        // 获取集合
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        FindIterable<Document> documents = collection.find();

        MongoCursor<Document> iterator = documents.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}
