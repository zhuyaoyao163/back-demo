package com.example.backdemo.leetcode.algorithm_92;

/**
 * @description:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @author: superman
 * @create: 2020-07-20 16:18
 **/
public class Solution {

    public static ListNode test1(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        //获取反转列表的前一个节点
        ListNode node = head;
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode nextHead = node.next;
        for (int i = m; i <= n; i++) {
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }
        node.next.next = next;
        node.next = pre;

        return res.next;
    }
}
