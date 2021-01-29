package com.example.demo.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * socket编程 实现服务器与客户端之间的自由交互
 *
 * 服务端
 */
public class C_014_Socket_Server {

    public static void main(String[] args) {
        try {
            createServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final int PORT = 886;
    private static final ServerSocket SERVER_SOCKET;
    static {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
            // 设置超时时间
            // serverSocket.setSoTimeout(10000);
        } catch (IOException e) {
            serverSocket = null;
            e.printStackTrace();
        }
        SERVER_SOCKET = serverSocket;
    }

    private static void createServer() throws IOException {
        while (true) {
            // 创建服务端socket连接
            Socket server = SERVER_SOCKET.accept();

            // 获取客户端的消息
            DataInputStream in = new DataInputStream(server.getInputStream());
            System.out.println("客户端 " + nowDateTime() + "\n" + in.readUTF());

            // 键盘输入
            // Scanner input = new Scanner(System.in);
            // System.out.println("服务端：");
            // String str = input.nextLine();
            String str = "服务端已收到您的消息！";
            // 发送至客户端
            DataOutputStream output = new DataOutputStream(server.getOutputStream());
            output.writeUTF(str);

            // 关闭客户端socket连接
            server.close();
        }
    }

    private static String nowDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dateTimeFormatter.format(LocalDateTime.now());
    }
}
