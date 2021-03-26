/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * @Author: zzStar
 * @Date: 02-08-2021 22:59
 */
public class RemoveDuplicatesFromSortedList083 {
    /**
     * 递归套路解决链表问题：
     * <p>
     * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
     * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
     * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
     * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;
    }

    /**
     * 由于给定的链表是排好序的，因此重复的元素在链表中出现的位置是连续的，因此我们只需要对链表进行一次遍历，就可以删除重复的元素。
     * <p>
     * 具体地，我们从指针 cur 指向链表的头节点，随后开始对链表进行遍历。如果当前 cur 与 cur.next 对应的元素相同，
     * 那么我们就将 cur.next 从链表中移除；否则说明链表中已经不存在其它与 cur 对应的元素相同的节点，因此可以将 cur 指向 cur.next。
     * <p>
     * 当遍历完整个链表之后，我们返回链表的头节点即可。
     * <p>
     * 细节
     * <p>
     * 当我们遍历到链表的最后一个节点时，cur.next 为空节点，如果不加以判断，访问 cur.next 对应的元素会产生运行错误。因此我们只需要遍历到链表的最后一个节点，而不需要遍历完整个链表。
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
