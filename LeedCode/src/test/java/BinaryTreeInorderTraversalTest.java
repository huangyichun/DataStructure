import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import static org.junit.Assert.*;

/**
 * Created by huangyichun on 2017/7/3.
 */
public class BinaryTreeInorderTraversalTest {
    @Test
    public void inorderTraversal() throws Exception {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;

        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        traversal.inorderTraversal(root);
    }

}