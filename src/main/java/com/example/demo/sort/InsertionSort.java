package com.example.demo.sort;

/**
 * 插入排序
 *
 * 算法思想：
 *
 * @author muyizuo
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 7, 1, 6, 4, 3};
        System.out.print("原数组：");
        printArr(arr);

        sort(arr);
    }

    private static void sort(int[] arr) {

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
