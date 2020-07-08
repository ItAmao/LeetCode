package com.amao.easy.easy_20;
/**
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/17 10:07 上午
 */

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        //1.申明一个栈,名字叫stack 里边存放的元素叫Character
        Stack<Character> stack = new Stack();
        //2遍历传入的字符串S
        for (int i = 0; i < s.length(); i++) {
            //3.把s中的第i个字符是什么样子的 赋值给c
            char c = s.charAt(i);
            //4.判断 如果c等于 ( { [中任意一个 把他压入栈中
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            //否则的话 就是 ) } ] 中的任意一个 把他拿出来作比较
            else {
                //如果栈顶为空 返回false
                if (stack.isEmpty()) {
                    return false;
                }
                //栈顶不为空 吧栈顶的元素拿出来
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean a =new Solution().isValid("(){}[]");
        System.out.println(a);
    }
}
