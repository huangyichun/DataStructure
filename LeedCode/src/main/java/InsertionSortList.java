/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pedSort = head.next;
        head.next = null;
        ListNode node = new ListNode(Integer.MIN_VALUE);
        node.next = head;
        head = node;
        while (pedSort != null){
            ListNode pre = head;
            ListNode next = pre.next;
            while (next != null && next.val <= pedSort.val) {
                pre = next;
                next = next.next;
            }
            ListNode temp = pedSort;
            pedSort = pedSort.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return head.next;
    }
}
