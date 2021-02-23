package com.example.demo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数器 检查算法是否正确
 *
 * @author muyizuo
 */
public class DataChecker {

    public static void main(String[] args) {
        Random random = new Random(1);
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        /*for (int i : arr) {
            System.out.print(i + " ");
        }*/
    }
}
