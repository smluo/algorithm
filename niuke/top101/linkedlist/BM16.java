package niuke.top101.linkedlist;

/**
 * 删除有序链表中重复的元素-II
 */
public class BM16 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                // *********************下面while循环很重要，是把相同元素的值从前往后挨个删掉********************
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return res.next;
    }
}
