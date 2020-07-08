package com.amao.easy.easy_1047;

import java.util.Stack;

public class Solution {
    public  String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();//Character 类在对象中包装一个基本类型 char 的值
        for (int i = 0; i < S.length(); i++) {
            char a = S.charAt(i);
            if (stack.isEmpty() || a != stack.peek()) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character b : stack) {
            stringBuilder.append(b);
        }
        return stringBuilder.toString();
    }

}
