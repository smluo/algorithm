package niuke.top101.linkedlist;

public class BM2 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = res;
        ListNode cur = head;
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        for (int i = m; i < n; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            // 下面这句话很重要，主要理解tmp.next = pre.next;而不是tmp.next = cur;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return res.next;
    }

    public void list(ListNode head) {
        if (head == null) {
            System.out.println("链表为空~~");
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

class BM2Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        BM2 bm2 = new BM2();
        ListNode node = bm2.reverseBetween(head, 2, 4);
        bm2.list(node);
    }
}