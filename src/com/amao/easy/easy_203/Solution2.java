package com.amao.easy.easy_203;

public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        //设置虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //如果待删除的节点是中间节点的话,这时候需要待删除节点的前一个节点prev
        ListNode prev = dummyHead;//初始化prev
        while (prev.next != null) {//prev的下一个节点不是null的话 继续循环
            if (prev.next.val == val) {//如果prev的下一个节点是待删除的元素
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;//如果不是,则向前寻找
            }
        }
        return dummyHead.next;
    }
}
