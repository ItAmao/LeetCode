package com.amao.easy.easy_682;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("+")) {//前两轮有效总和
                //方法是 先把栈顶的元素 取出来 然后用现在取出来的元素加上新的栈顶的元素
                //最后把两个数压入栈
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        for (int j : stack) {
            sum += j;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution.calPoints(ops));
    }
}
