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
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            // 临时节点，暂存当前节点的下一节点，用于后移
            ListNode next = cur.next;
            // 将当前节点指向它前面的节点
            cur.next = pre;
            // 前指针后移
            pre = cur;
            // 当前指针后移
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


}
