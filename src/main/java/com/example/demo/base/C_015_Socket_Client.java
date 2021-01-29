package com.example.demo.base;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * socket编程 实现服务器与客户端之间的自由交互
 *
 * 客户端
 */
public class C_015_Socket_Client {

    public static void main(String[] args) {
        try {
            createClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String HOST = "localhost";
    private static final int PORT = 886;

    private static void createClient() throws IOException {
        while (true) {
            // 创建客户端socket连接
            Socket client = new Socket(HOST, PORT);

            // 键盘输入
            Scanner input = new Scanner(System.in);
            System.out.println("客户端：");
            String str = input.nextLine();
            // 输出至服务器
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            output.writeUTF(str);

            // 获取服务端的消息
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("服务端 " + nowDateTime() + "\n" + in.readUTF());

            // 关闭客户端socket连接
            client.close();
        }
    }

    private static String nowDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
