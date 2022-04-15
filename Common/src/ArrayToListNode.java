/**
 * @Author: zzStar
 * @Date: 04-14-2022 10:01
 */
public class ArrayToListNode {

    static ListNode arrayToListNode(int[] a) {
        ListNode root = new ListNode(a[0]);
        ListNode other = root;
        for (int i = 1; i < a.length; i++) {
            ListNode temp = new ListNode(a[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }

    static void listNodeToArray(ListNode head) {
        while (head != null) {
            System.out.println(String.valueOf(head.val));
            head = head.next;
        }
    }

}
