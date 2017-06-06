/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given{1,2,3,4}, reorder it to{1,4,2,3}.
 * 快慢指针找到中间位置，逆序中间位置之后的节点
 * 交替插入
 */
public class LeetCode_8 {

    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode quik = head;
        while (quik != null && quik.next != null) {//找到中间节点
            quik = quik.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        while (next != null) {//链表翻转
            ListNode temp = next.next;
            next.next = slow.next;
            slow.next = next;
            next = temp;
        }

        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        while (second != null) {
            ListNode node = second.next;
            second.next = first.next;
            first.next = second;
            first = second.next;
            second = node;
        }
    }
}
