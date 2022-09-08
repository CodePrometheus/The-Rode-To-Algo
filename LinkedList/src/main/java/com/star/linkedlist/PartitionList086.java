package com.star.linkedlist;

import com.star.common.ListNode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 04-28-2021 20:46
 */
public class PartitionList086 {

    /**
     * 维护两个链表，small，large存储所有大于等于x的节点
     * 遍历完链表之后，只将small尾节点指向large头节点即可
     * 设置smallHead，和largeHead分别为两个链表的虚拟头节点
     * 方便处理头节点为空的边界条件，同时设 small 和 large 节点指向当前链表的末尾节点
     * 判断当前链表的节点值是否小于 x，如果小于就将 small 的 next 指针指向该节点，否则将 large 的 next 指针指向该节点。
     * 遍历结束后，将large的next指针置空，因为当前节点复用的是原链表的节点，而其 next 指针可能指向一个小于 x的节点，需要切断这个引用。
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // 合并
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
