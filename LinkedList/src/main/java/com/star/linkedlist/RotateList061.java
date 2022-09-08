package com.star.linkedlist;

import com.star.common.ListNode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * <p>
 * 示例1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-26-2021 22:11
 */
public class RotateList061 {

    /**
     * 本质上是将尾部向前数第K个元素作为头，原来的头接到原来的尾上
     * 先遍历求得链表总长度count，同时将链表首尾相连；
     * 再找到原链表的倒数第k+1个节点，该节点的next就是新链表的头结点
     * 形成环，再移动，最后断开
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 用来统计链表总结点数
        int count = 1;
        // 找尾节点，形成环形链表
        ListNode tail = head;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        // 尾节点移动 length - k 步
        k = k % count;
        // 当k为0时，不需要旋转，
        if (k == 0) {
            return head;
        }

        // 不满足上述条件，必将进行旋转，所以先将首尾相连
        tail.next = head;
        // 现在只需要找到倒数第k+1个节点
        for (int i = 0; i < count - k; i++) {
            tail = tail.next;
        }
        // 找到头节点，断开头尾连接
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }

}
