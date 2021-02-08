package com.example.demo.base;

public class C_016 {

    public static void main(String[] args) {
        // String[] strs = {"flower","flow","flight"};
        // String[] strs = {"a"};
        String[] strs = {"dog","racecar","car"};
        System.out.println(m1(strs));
    }

    private static String m1(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            commonPrefix.append(strs[0].charAt(i));
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(commonPrefix.toString())) {
                    return commonPrefix.deleteCharAt(commonPrefix.length() - 1).toString();
                }
            }
        }
        return commonPrefix.toString();
    }
}
