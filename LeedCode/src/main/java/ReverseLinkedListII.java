/**
 * Created by huangyichun on 2017/7/25.
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(0);//设置一个头节点
        first.next = head;

        ListNode current = first, preStart = null, start, end;

        for (int i=0; i < n; ++i) {
            if (i == m-1){//找到逆转的前置节点
                preStart = current;
            }
            current = current.next;
        }
        end = current; //逆转的结束节点
        start = preStart.next; //逆转开始节点

        preStart.next = end.next;
        while(m <= n) {//采用头插法进行逆转链表
            ListNode temp = start.next;
            start.next = preStart.next;
            preStart.next =  start;
            start = temp;
            ++m;
        }
        return first.next;
    }
}
