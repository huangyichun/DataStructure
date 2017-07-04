/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 * 1
 * /  \
 * 2    3
 * <p>
 * Return6.
 */
public class LeetCode_27 {

    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    /**
     * 获取左右子树的最大值
     * @param root 根结点
     * @return
     */
    public int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathDown(root.left), 0);
        int right = Math.max(maxPathDown(root.right), 0);
        maxValue = Math.max(maxValue, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
