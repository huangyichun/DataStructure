/**
 * 题目描述
 * 对于一个元素各不相同且按升序排列的有序序列，请编写一个算法，创建一棵高度最小的二叉查找树。
 * 给定一个有序序列int[] vals,请返回创建的二叉查找树的高度。
 */
public class MinimalBST {

    public int buildMinimalBST(int[] vals) {
        // write code here
        TreeNode root = createMinimalBST(vals, 0, vals.length-1);
        return getDeep(root);
    }

    /**
     * 求树高度
     * @param root
     * @return
     */
    public int getDeep(TreeNode root){
        if(root == null)
            return 0;
        int left = getDeep(root.left);
        int right = getDeep(root.right);
        return Math.max(left, right) + 1;
    }

    //创建一棵二叉查找树
    public TreeNode createMinimalBST(int[] vals, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(vals[mid]);
        root.left = createMinimalBST(vals, start, mid-1);
        root.right = createMinimalBST(vals, mid+1, end);
        return root;
    }
}
