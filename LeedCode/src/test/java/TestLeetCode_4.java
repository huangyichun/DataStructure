import org.junit.Assert;
import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/5.
 */
public class TestLeetCode_4 {

    @Test
    public void test(){
        ListNode head = new ListNode(5);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(10);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LeetCode_4 leetCode_4 = new LeetCode_4();
        ListNode node = leetCode_4.sortList(head);
        Assert.assertEquals(node.val, 1);
    }
}
