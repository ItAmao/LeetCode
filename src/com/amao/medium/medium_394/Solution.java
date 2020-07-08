package com.amao.medium.medium_394;

import java.util.Collections;
import java.util.Stack;

/**
 *  对字符串进行解析,字符串中的数字是次数,对后边[]的内容输出对应的次数
 *  2[ab3[c]]  abcccabccc
 *  2[2[ab]]  abababab
 *  @Author : ItAmao
 *  @Date   : 2020/7/1 08:56
 */
public class Solution {
    public static void main(String[] args) {
        String nums = "2[ab3[c]]";
        String string = decodeString(nums);
        System.out.println(string);
    }

    public static String decodeString(String s) {
        char[] chs = s.toCharArray();
        Stack<Object> stack = new Stack<>();
        //num是用于记录左括号前边的数字
        int num = 0;
        for (char c : chs) {
            //判断字符是否为数字
            if (Character.isDigit(c)) {
                // 1. 数字则直接计算
                // 括号前的数字是多少，不一定是一位数。
                num = num * 10 + c - '0';
            } else if (c == '[') {
                // 2. 左括号, 先要把前面的数字放进去, 左中括号不用入栈
                stack.push(num);
                num = 0;
            } else if (c == ']') {
                // 3. 右括号, 出栈, 获取局部字符串再根据前面的数字得到乘次数再放入stack
                String str = popAndGetString(stack);
                int times = (int) stack.pop();
                //join 第一个参数"" 表示中间连接的东西,nCopies方法用于返回一个不可变列表组成的n个拷贝的指定对象。
                String temp = String.join("", Collections.nCopies(times, str));
                stack.push(temp);
            } else {
                stack.push(String.valueOf(c));
            }
        }
        return new StringBuilder(popAndGetString(stack)).reverse().toString();
    }

    private static String popAndGetString(Stack<Object> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() instanceof String) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}

