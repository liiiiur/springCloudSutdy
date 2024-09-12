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
        nodeSet.add(head.val);
        while (head.next != null) {
            if (!nodeSet.contains(head.next.val)) {
                nodeSet.add(head.next.val);
                head = head.next;
            } else {
                head.next = head.next.next;
            }
        }
        return listNode;
    }

    /**
     * 合并有序链表（非递归）
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode curr = prev;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            }else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        if(list1 != null) {
            curr.next = list1;
        }
        if(list2 != null) {
            curr.next = list2;
        }
        return prev.next;
    }

    /**
     * 并有序链表（递归）
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    /**
     * 是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否有环，有则返回第一个入节点，否则null
     * @param head
     * @return
     */
    public static ListNode cycleNode(ListNode head) {
        if (head == null || head.next == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                fast = head;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if(fast == slow) {
                        return slow;
                    }
                }
            }
        }
        return  null;
    }

    /**
     * 单链表是否相交
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        boolean a = hasCycle(headA);
        boolean b = hasCycle(headB);
        if(a!=b)return null;
        if(a){

        }
        return null;
    }

}
