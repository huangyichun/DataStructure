import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * return[3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 非递归遍历后序遍历二叉树
 */
public class BinaryTreePostorderTraversal {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode peek = stack.peek();
            if (peek.left == null && peek.right == null) {
                list.add(stack.pop().val);
            }else {
                if (peek.right != null) {
                    stack.push(peek.right);
                    peek.right = null;
                }
                if (peek.left != null) {
                    stack.push(peek.left);
                    peek.left = null;
                }
            }
        }
        return list;
    }
}

