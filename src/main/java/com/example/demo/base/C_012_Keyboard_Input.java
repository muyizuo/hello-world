package com.example.demo.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 键盘输入
 *
 */
public class C_012_Keyboard_Input {

    private static void byScanner() {
        System.out.println("方式一：通过Scanner");
        Scanner input = new Scanner(System.in);
        // 直接输入
        // System.out.print("请输入：");
        // String s = input.nextLine();
        // System.out.println("您输入的内容是：" + s);

        // 循环输入
        for (;;) {
            System.out.print("请输入：");
            String s = input.nextLine();
            System.out.println("您输入的内容是：" + s);
        }
    }

    private static void byBufferedReader() throws IOException {
        System.out.println("方式二：通过BufferedReader");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        // 直接输入
        // System.out.print("请输入：");
        // String s = input.readLine();
        // System.out.println("您输入的内容是：" + s);

        // 循环输入
        for (;;) {
            System.out.print("请输入：");
            String s = input.readLine();
            System.out.println("您输入的内容是：" + s);
        }
    }

    public static void main(String[] args) {
        // byScanner();

        try {
            byBufferedReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
