import org.junit.Test;

/**
 * Created by huangyichun on 2017/6/15.
 */
public class TestLeetCode_27 {

    @Test
    public void test() {
        LeetCode_27 leetCode27 = new LeetCode_27();
        TreeNode node = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);
        node.right = node1;
        int sum = leetCode27.maxPathSum(node);
        System.out.println(sum);
    }
}
