package com.star.linkedlist;

import com.star.common.ArrayToListNode;
import com.star.common.ListNode;
import org.junit.Test;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @Author: zzStar
 * @Date: 03-08-2021 09:30
 */
public class ReverseLinkedList206 {

    /**
     * 迭代法
     * null -> 1 -> 2 -> 3 -> 4 -> null
     * null <- 1 <- 2 <- 3 <- 4 <- null
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     * n(k+1) -> n(k)
     * => n(K).next.next = n(K)
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    // 迭代
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList4(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur, next);
    }

    @Test
    public void sortTest() {
        // 测试 1-8-3-6-5-4-7-2-9
        ListNode l9 = new ListNode(9);
        ListNode l2 = new ListNode(2, l9);
        ListNode l7 = new ListNode(7, l2);
        ListNode l4 = new ListNode(4, l7);
        ListNode l5 = new ListNode(5, l4);
        ListNode l6 = new ListNode(6, l5);
        ListNode l3 = new ListNode(3, l6);
        ListNode l8 = new ListNode(8, l3);
        ListNode head = new ListNode(1, l8);
        ListNode ans = reverseList(head);
        // 9 2 7 4 5 6 3 8 1
        System.out.println(ans);
    }

    @Test
    public void test() {
        int[] a = new int[]{1, 8, 3, 6, 5};
        System.out.println(ArrayToListNode.arrayToListNode(a));
    }

}
