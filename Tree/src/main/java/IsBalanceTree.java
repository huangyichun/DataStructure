/**
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 *
 * 思路:
 * 1.后序遍历求出二叉树的左右子树的高度
 * 2.判断左右子树高度差是否大于1
 */
public class IsBalanceTree {


    //第一种解法:
    private boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {

        checkedBalance(root);
        return isBalance;
    }

    public int checkedBalance(TreeNode root){
        if(root == null)
            return 0;
        int left = checkedBalance(root.left);
        int right = checkedBalance(root.right);

        if(Math.abs(left-right) > 1)
            isBalance = false;

        return Math.max(left, right) + 1;
    }

    //第二种解法
    public boolean isBalance(TreeNode root) {
        // write code here
        int high = checkHeight(root);
        if(high == -1)
            return false;
        return true;

    }
    //判断二叉树是否平衡，平衡返回二叉树的高度，不平衡返回-1
    private int checkHeight(TreeNode root){
        if(root == null)
            return 0;

        int left = checkHeight(root.left);
        if(left == -1)  //不平衡
            return -1;

        int right = checkHeight(root.right);
        if(right == -1) //不平衡
            return -1;

        int heightDiff = left - right;//左右子树高度差
        if(Math.abs(heightDiff) > 1){
            return -1;
        }

        return Math.max(left,right) + 1;
    }
}



class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
