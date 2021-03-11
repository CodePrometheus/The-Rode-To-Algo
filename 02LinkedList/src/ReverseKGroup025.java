import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * 示例 4：
 * <p>
 * 输入：head = [1], k = 1
 * 输出：[1]
 * 提示：
 * <p>
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: zzStar
 * @Date: 03-11-2021 23:03
 */
public class ReverseKGroup025 {

    /**
     * 栈
     * 把 k 个数压入栈中，然后弹出来的顺序就是翻转的！
     * <p>
     * 这里要注意几个问题：
     * <p>
     * 第一，剩下的链表个数够不够 k 个（因为不够 k 个不用翻转）；
     * <p>
     * 第二，已经翻转的部分要与剩下链表连接起来。
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (true) {
            int count = 0;
            ListNode tmp = head;
            while (tmp != null && count < k) {
                stack.add(tmp);
                tmp = tmp.next;
                count++;
            }
            if (count != k) {
                p.next = head;
                break;
            }
            while (!stack.isEmpty()) {
                p.next = stack.pollLast();
                p = p.next;
            }
            p.next = tmp;
            head = tmp;
        }
        return dummy.next;
    }

    /**
     * 尾插法
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                count++;
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            ListNode head1 = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }
        return dummy.next;
    }

    /**
     * 递归
     */
    public ListNode reverseKGroup3(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count != 0) {
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }

    /**
     * 递归
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup4(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    /**
     * 左闭又开区间
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
