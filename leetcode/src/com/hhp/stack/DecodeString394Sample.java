package com.hhp.stack;

import java.util.Stack;

public class DecodeString394Sample {

    public static String decodeString(String s) {
        String res = "";
        // 记录倍数的栈
        Stack<Integer> countStack = new Stack<>();
        // 记录字符串的栈
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            char cur = s.charAt(idx);
            if (Character.isDigit(cur)) {
                // 将字符串重复的次数取出
                StringBuilder ret = new StringBuilder();
                while (Character.isDigit(s.charAt(idx))) {
                    ret.append(s.charAt(idx++));
                }
                countStack.push(Integer.parseInt(ret.toString()));
            } else if (cur == '[') {
                // 遇到左括号，将字符串内容压入栈内
                resStack.push(res);
                // 清空字符串内容
                res = "";
                idx++;
            } else if (cur == ']') {
                // 遇到右括号，从栈中取出字符串
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                // 将取出的字符串重复拼接
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }
}
