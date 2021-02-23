package com.example.demo.sort;

/**
 * 选择排序
 *
 * 最简单且最没用的排序。时间复杂度较高，且不稳定。
 *
 * 算法思想：经多次遍历，每次遍历找到最小值的位置，将其排到最前面
 * 平均时间复杂度：O(n^2)
 * 最坏时间复杂度：O(n^2)
 * 最好时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳（当存在两个相同的数值时，排完序之后这两个值的相对顺序可能会发生变化。原因：数值之间交换位置时不是两两交换。）
 *
 * 优化方案：
 * 1.经多次遍历，每次遍历找到最小值，同时也找到最大值，将最小值排到最前面，将最大值排到最后面。
 *
 * @author muyizuo
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 7, 1, 6, 4, 3};
        System.out.print("原数组：");
        printArr(arr);

        // sort1(arr);
        sort2(arr);
    }

    /**
     * 选择排序 原始的实现方案
     *
     * 经多次遍历，每次遍历找到最小值的位置，将其排到最前面
     *
     * @param arr
     */
    public static void sort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 初始化最小值的索引
            int minIndex = i;
            // 遍历比较，找出最小值的索引
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小值放到前面
            swap(arr, minIndex, i);

            // 打印中间结果
            System.out.print("经过第" + (i + 1) + "次排序操作后数组的元素：");
            printArr(arr);
        }
    }

    /**
     * 选择排序 优化后的实现方案
     * 经多次遍历，每次遍历找到最小值，同时也找到最大值，将最小值排到最前面，将最大值排到最后面。
     *
     * @param arr
     */
    private static void sort2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            // 初始化最小值的索引
            int minIndex = i;
            // 初始化最大值的索引
            int maxIndex = i;
            // 遍历比较，找出最小值、最大值的索引
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 将最小值放到前面
            swap(arr, i, minIndex);
            // 上一步交换过程中，若最小值需要放的位置恰好是最大值的位置，则修改最大值的索引
            if (maxIndex == i) {
                maxIndex = minIndex;
            }
            // 将最大值放到后面
            swap(arr, arr.length - 1 - i, maxIndex);

            // 打印中间结果
            System.out.print("经过第" + (i + 1) + "次排序操作后数组的元素：");
            printArr(arr);
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
