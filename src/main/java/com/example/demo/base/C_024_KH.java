package com.example.demo.base;

import java.util.Stack;

public class C_024_KH {

    public static void main(String[] args) {
        // 栈
        Stack stack = new Stack();
        // 查看栈是否为空
        System.out.println(stack.empty());
        // 入栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        // 查看栈顶元素
        System.out.println(stack.peek());
        // 出栈
        System.out.println(stack.pop());
        // 查看指定元素位置 -1表示不存在
        System.out.println(stack.search(5));
        System.out.println(stack.search(2));

        /*String s = "()[]{}";
        Stack<Character> stk = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

        }*/
    }
}
