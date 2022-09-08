package com.star.common;

/**
 * @Author: zzStar
 * @Date: 04-14-2022 10:01
 */
public class ArrayToListNode {
    public static ListNode arrayToListNode(int[] a) {
        ListNode root = new ListNode(a[0]);
        ListNode other = root;
        for (int i = 1; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    public static void listNodeToArray(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            if (head.next == null) {
                sb.append(head.val);
            } else {
                sb.append(head.val).append(",");
            }
            head = head.next;
        }
        System.out.print(sb);
    }
}
