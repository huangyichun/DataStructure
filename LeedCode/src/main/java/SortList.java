/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = sortList(head, null);
        return node;
    }

    public ListNode sortList(ListNode start, ListNode end) {
        if (start == end || start.next == end) {
            start.next = null;
            return start;
        }
        ListNode mid = getMidListNode(start, end);
        ListNode left = sortList(start, mid);
        ListNode right = sortList(mid, end);

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode pre = head, pStart = left, pMid = right;

        while (pStart != null && pMid != null) {
            if (pStart.val <= pMid.val) {
                pre.next = pStart;
                pStart = pStart.next;
                pre = pre.next;
            } else {
                pre.next = pMid;
                pMid = pMid.next;
                pre = pre.next;
            }
        }
//        if((pStart == mid && pMid.next == end) || (pMid == end) )
        while (pStart != null) {
            pre.next = pStart;
            pStart = pStart.next;
            pre = pre.next;
        }
        while (pMid != null) {
            pre.next = pMid;
            pMid = pMid.next;
            pre = pre.next;
        }
        pre.next = null;
        return head.next;
    }

    public ListNode getMidListNode(ListNode start, ListNode end) {
        ListNode stepOne = start;
        ListNode stepTwo = start;
        while (stepTwo != end && stepTwo.next != end) {
            stepTwo = stepTwo.next.next;
            stepOne = stepOne.next;
        }
        return stepOne;
    }
}
