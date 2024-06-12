package com.wangxia.core.test.leetCode.listNode;


import java.util.HashSet;

public class ListSolution {
    /**
     * 反转单链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 移除链表重复数据
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode listNode = head;
        HashSet<Integer> nodeSet = new HashSet<>();
        nodeSet.add(head.data);
        while (head.next != null) {
            if (!nodeSet.contains(head.next.data)) {
                nodeSet.add(head.next.data);
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return listNode;
    }

}
