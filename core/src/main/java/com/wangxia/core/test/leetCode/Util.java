package com.wangxia.core.test.leetCode;


import com.wangxia.core.test.leetCode.listNode.ListNode;

public class Util {

    /**
     * 交换数组
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        if (i == j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }else {
            arr[i] = arr[i]^arr[j];
            arr[j] = arr[i]^arr[j];
            arr[i] = arr[i]^arr[j];
        }

    }

    /**
     * 生成随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((Math.random() * (maxValue+1))-(int)(Math.random()*maxValue));
        }
        return arr;
    }

    /**
     * 比较数组值是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean compare(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length){return false;}
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 生成随机链表
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static ListNode generateRandomList(int maxSize, int maxValue) {
        int[] arr = generateRandomArray(maxSize, maxValue);
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    /**
     * 生成双向链表
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static ListNode generateDoubleList(int maxSize, int maxValue) {
        int[] arr = generateRandomArray(maxSize, maxValue);
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        ListNode prev = null;
        for (int i = 1; i < arr.length; i++) {
            cur.last=prev;
            cur.next = new ListNode(arr[i]);
            prev = cur;
            cur = cur.next;
        }
        return head;
    }
}
