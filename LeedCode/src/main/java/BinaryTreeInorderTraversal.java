import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * return[1,3,2].
 * Note: Recursive solution is trivial, could you do it iteratively?
 * confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.
 *
 * 采用非递归实现中序遍历
 */
public class BinaryTreeInorderTraversal {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();

        while(!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                root = temp.right;
            }
        }
        return list;
    }
}
