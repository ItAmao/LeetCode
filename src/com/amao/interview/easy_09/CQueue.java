package com.amao.interview.easy_09;
/**
 * @description: 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * <p>
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * @params:
 * @return:
 * @author: amao
 * @time: 2020/5/17 7:16 下午
 */

import java.util.Stack;

public class CQueue {
    Stack<Integer> stack1;//只负责进
    Stack<Integer> stack2;//只负责出
    int size;//栈中元素个数

    public CQueue() {//初始化操作
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }

    public void appendTail(int value) {
        stack1.push(value);//stack1只负责接收进来的元素
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());//把stack1存入的元素取出来 压入stack2中 这样就实现队列的效果
            }
        }
        return stack2.pop();//然后把stack2栈中的元素 取出来
    }

}
