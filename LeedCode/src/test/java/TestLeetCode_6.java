import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by huangyichun on 2017/6/6.
 */
public class TestLeetCode_6 {

    @Test
    public void test(){
        LeetCode_6 leetCode_6 = new LeetCode_6();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        root.right = node1;
        node1.right = node2;
        ArrayList<Integer> list = leetCode_6.postorderTraversal(root);
        list.forEach(System.out::print);
    }
}
