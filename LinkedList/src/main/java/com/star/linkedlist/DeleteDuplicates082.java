package com.star.linkedlist;

import com.star.common.ListNode;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-25-2021 23:44
 */
public class DeleteDuplicates082 {

    /**
     * 递归实现
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;

        /**
         * 两种情况
         * 1. 1 --> 1 --> 1 --> 2 --> 3
         * 则需要移动next直到出现与当前head.value不相等的情况（含null）
         * 并且此时的head已经不能要了，因为已经head是重复的节点
         */
        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }
            head = deleteDuplicates(next);
        } else {
            /**
             * 2. 1 --> 2 --> 3
             * 如果没有出现1的情况，则递归返回的节点就作为head的子节点
             */
            head.next = deleteDuplicates(next);
        }
        return head;
    }
}
