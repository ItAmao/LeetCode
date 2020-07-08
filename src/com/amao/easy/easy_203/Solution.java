package com.amao.easy.easy_203;

/**
 * @description: 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * /**
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 * @params:
 * @return:
 * @author:amao
 * @time:2020/5/19 9:14上午
 */

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //如果待删除的元素是头结点head的话,用while循环,因为有可能第二个节点也是要删除的元素
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;//把head往前移动
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        //如果待删除的节点是中间节点的话,这时候需要待删除节点的前一个节点prev
        ListNode prev = head;//初始化prev
        while (prev.next != null) {//prev的下一个节点不是null的话 继续循环
            if (prev.next.val == val) {//如果prev的下一个节点是待删除的元素
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;//如果不是,则向前寻找
            }
        }
        return head;
    }
}
