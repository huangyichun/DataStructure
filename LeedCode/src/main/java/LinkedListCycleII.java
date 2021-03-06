/**
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        do {
            if (quick == null || quick.next == null) {
                return null;
            }
            slow = slow.next;
            quick = quick.next.next;
        }while (quick != slow);

        ListNode pre = head;
        while(pre != slow){
            pre = pre.next;
            slow = slow.next;
        }
        return slow;
    }
}
