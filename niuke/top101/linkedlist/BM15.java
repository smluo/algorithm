package niuke.top101.linkedlist;

import java.util.TreeSet;

/**
 * 删除有序链表中重复的元素-I
 */
public class BM15 {

    /**
     * 必须要使用treemap因为它的存储和读取是有序的，这种方法就算链表不是有序的一样可以使用
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        TreeSet<Integer> treeSet = new TreeSet();
        while (head != null) {
            treeSet.add(head.val);
            head = head.next;
        }
        ListNode res = new ListNode(-1);
        while (treeSet.size() > 0) {
            ListNode temp = new ListNode(treeSet.pollLast());
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;
    }

    /**
     * 官方推荐方法，但是有两个点容易犯错
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates1 (ListNode head) {
        // write code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            // *****************重要：cur.val != null这个条件不要忘记加***************
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
                // ************重要：这里continue必须，或者不加continue改成else{cur = cur.next}***************
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}
