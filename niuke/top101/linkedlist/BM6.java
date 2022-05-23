package niuke.top101.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * BM6 判断链表中是否有环
 */
public class BM6 {
    /**
     * 哈希方式处理，暴力方式
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode cur = head;
        Set<ListNode> set = new HashSet();
        while (cur != null) {
            if (!set.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 快慢指针，
     * 为什么如果快指针一次走三步就不行了呢？
     * 因为1是任何整数的约数，环的长度就是快指针比慢指针多走的长度，
     * 这个长度一定可以被1整除，但是不一定被大于1的任何数字整除。所以快指针只能比慢指针快一步。
     *
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
