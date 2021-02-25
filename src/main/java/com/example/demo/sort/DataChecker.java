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
        System.out.println(check(generateRandomArray()));
    }

    /**
     * 生成随机数组
     *
     * @return
     */
    static int[] generateRandomArray() {
        Random random = new Random(1);
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    /**
     * 对数
     *
     * @param arr
     * @return
     */
    static boolean check(int[] arr) {
        // 复制一份数据
        int[] arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);

        // 与确定正确的算法结果进行比较
        Arrays.sort(arr);
        // SelectionSort.sort(arrCopy);
        // SelectionSort.sort2(arrCopy);
        // BubbleSort.sort(arrCopy);
        // BubbleSort.sort2(arrCopy);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arrCopy[i]) {
                return false;
            }
        }
        return true;
    }
}
