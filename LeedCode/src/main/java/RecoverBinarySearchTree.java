/**
 * 题目描述
 * <p>
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n ) space is pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {

    TreeNode firstNode, secondNode;
    TreeNode minNode = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        traver(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    /**
     * 二叉搜索树中序遍历是按照有序的顺序输出的
     * 所以前一个数总是小于后一个数
     * 有两种情况，一种是逆序的数有两个
     * 一种逆序数只有一个
     * @param root
     */
    public void traver(TreeNode root) {
        if(root == null) {
            return;
        }
        traver(root.left);
        //要在存在2个逆序数中改变数组为有序，第一个应该取大的数，第二个应该取小的数
        if (firstNode == null && minNode.val > root.val) {
            firstNode = minNode;
        }
        if (firstNode != null && minNode.val > root.val) {
            secondNode = root;
        }
        minNode = root;//每次都应该指向最小的数
        traver(root.right);
    }
}
