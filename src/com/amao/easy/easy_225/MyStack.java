package com.amao.easy.easy_225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {//初始化
        queue = new LinkedList<>();//因为队列基于链表构成的
    }

    //因为队列是先进先出的,所以可以先入队
    //然后倒转元素 相当于把队首的元素放在最后,循环一次,最后一开始在队尾的元素就到了队首
    //相当于 (1,2,3,4,5,6,7,8)->(8,1,2,3,4,5,6,7)在一直遍历
    public void push(int x) {
        queue.add(x);
        for (int i = 1; i < queue.size(); i++) {//因为是队列,所以int i应该等于1
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.poll();//poll会返回null 而remove抛出异常
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}
