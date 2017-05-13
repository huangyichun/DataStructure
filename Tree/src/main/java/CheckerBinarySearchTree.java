/**
 * 题目描述
 * 请实现一个函数，检查一棵二叉树是否为二叉查找树。
 * 给定树的根结点指针TreeNode* root，请返回一个bool，代表该树是否为二叉查找树。
 */
public class CheckerBinarySearchTree {
    /**
     * 思路:
     * 二叉树根节点处于Integer最小值和Integer最大值之间
     * 它的左子树满足Integer.MIN_VALUE到root.val之间
     * 它的右子树满足root.val到Integer.MAX_VALUE之间
     * @param root
     * @return
     */
    public boolean checkBST(TreeNode root) {
        // write code here
        if (root == null)
            return true;

        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
}
