package com.example.demo.sort;

/**
 * 冒泡排序
 *
 * 算法思想：经多次遍历，每次从0的位置开始，每次将最大值放到最后面。
 * 平均时间复杂度：O(n^2)
 * 最坏时间复杂度：O(n^2)
 * 最好时间复杂度：O(n)
 * 空间复杂度：O(1)
 * 稳定性：稳定（两两比较）
 *
 * 优化方案：
 * 1.实现时间复杂度为O(n)的算法方案
 *
 * @author muyizuo
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 7, 1, 6, 4, 3, 9};

        sort2(arr);

        printArr(arr);
    }

    /**
     * 冒泡排序 原始实现方案
     *
     * @param arr
     */
    static void sort(int[] arr) {
        // 限定大值最终放的位置，逐次递减
        for (int i = arr.length - 1; i > 0; i--) {
            // 将大的值往后放
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序 优化实现方案
     *
     * 优化点：实现时间复杂度为O(n)的算法方案（最好时间复杂度，假定对已经有序的数组进行排序）
     *
     * 如果内层某一遍历过程中（从0开始，将最大数放到最右边），没有进行任何位置交换，则说明数组已经有序
     *
     * @param arr
     */
    static void sort2(int[] arr) {
        // 内层一次遍历是否有元素位置交换
        boolean didSwap;
        // 限定大值最终放的位置，逐次递减
        for (int i = arr.length - 1; i > 0; i--) {
            didSwap = false;
            // 将大的值往后放
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    didSwap = true;
                }
            }
            // 没有进行任何位置交换，则说明数组已经有序，可以结束
            if (!didSwap) {
                break;
            }
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
