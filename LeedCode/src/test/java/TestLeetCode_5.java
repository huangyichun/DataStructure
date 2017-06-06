import org.junit.Assert;
import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/6.
 */
public class TestLeetCode_5 {

    @Test
    public void inputSecondNodeShouldReturnMinNode(){
        LeetCode_5 leetCode_5 = new LeetCode_5();
        ListNode head = new ListNode(5);
        ListNode one = new ListNode(3);
        head.next = one;
        ListNode node = leetCode_5.insertionSortList(head);
        Assert.assertEquals(node.val, 3);
    }
}
