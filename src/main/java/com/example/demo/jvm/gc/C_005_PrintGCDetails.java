package com.example.demo.jvm.gc;

/**
 * 打印GC详细信息
 *
 * 设置VM参数 -XX:+PrintGCDetails
 */
public class C_005_PrintGCDetails {

    public static void main(String[] args) {
        byte[] a, b, c, d, f, g;
        // a 创建时，eden区内存几乎被分配完全
        a = new byte[28500 * 1024];
        // b 创建时，eden区几乎满了，则会触发Minor GC
        // GC期间发现 a 无法存入Survivor区，
        b = new byte[1000 * 1024];
        // c = new byte[1000 * 1024];
        // d = new byte[1000 * 1024];
        // f = new byte[1000 * 1024];
    }
}
