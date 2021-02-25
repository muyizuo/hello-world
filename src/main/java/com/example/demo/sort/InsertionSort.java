package com.example.demo.sort;

/**
 * 插入排序
 *
 * 算法思想：从第二个位置开始（下标为1），将其与前面的值比较，如果比前面的值小，则和前面的值交换位置，直到放到正确位置
 * 平均时间复杂度：O(n^2)
 * 最坏时间复杂度：O(n^2)
 * 最好时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 稳定性：稳定（两两比较）
 *
 * @author muyizuo
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 7, 1, 6, 4, 3, 9};

        // sort(arr);
        sort2(arr);

        printArr(arr);
    }

    /**
     * 插入排序 原始实现方案
     *
     * @param arr
     */
    private static void sort(int[] arr) {
        // 从第二个位置开始，直到最后一个位置
        for (int i = 1; i < arr.length; i++) {
            // 把小的值往前放
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    /**
     * 优化方案：去除swap方法
     *
     * @param arr
     */
    private static void sort2(int[] arr) {
        // 从第二个位置开始，直到最后一个位置
        for (int i = 1; i < arr.length; i++) {
            // 把小的值往前放
            int temp = arr[i];
            int index = i;
            for (int j = i; j > 0; j--) {
                /*if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }*/
                if (arr[j] < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    index = j - 1;
                }
            }
            arr[index] = temp;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
