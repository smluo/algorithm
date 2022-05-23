package niuke.top101.linkedlist;

/**
 * 反转链表
 */
public class BM1 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode res = new ListNode(-1);
        while (cur != null) {
            ListNode temp = new ListNode(cur.val);
            temp.next = res.next;
            res.next = temp;
            cur = cur.next;
        }
        return res.next;
    }

    public ListNode ReverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

