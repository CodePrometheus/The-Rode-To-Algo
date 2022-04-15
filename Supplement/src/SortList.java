import org.junit.Test;

/**
 * 排序奇升偶降链表
 *
 * @Author: zzStar
 * @Date: 11-20-2021 13:20
 */
public class SortList {

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
        ListNode ans = sort(head);
        // 1 2 3 4 5 6 7 8 9
        System.out.println(ans);
    }

    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode e = head, o = head.next, pre = e, cur = o;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            pre.next = next;
            pre = pre.next;
            cur = cur.next;
        }
        o = reverse(o);
        return merge(e, o).next;
    }

    public ListNode reverse(ListNode head) {
        ListNode du = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = du;
            du = cur;
            cur = tmp;
        }
        return du;
    }

    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode du = new ListNode(0), cur = du;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = h1 == null ? h2 : h1;
        return du;
    }
}
