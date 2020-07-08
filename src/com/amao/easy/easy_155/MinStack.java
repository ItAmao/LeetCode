package com.amao.easy.easy_155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack1;//用于存储
    private Stack<Integer> stack2;//用于辅助

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.add(x);
        } else {
            stack2.add(stack2.peek());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }

    public int getMin() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        throw new RuntimeException("栈中元素为空，此操作非法");
    }
}
