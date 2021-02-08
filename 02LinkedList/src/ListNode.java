public class ListNode<E> {
    E val;
    ListNode next;

    ListNode() {
    }

    ListNode(E val) {
        this.val = val;
    }

    ListNode(E val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    private ListNode dummyHead;
    private int size;

    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new ListNode(e, pre.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

}
