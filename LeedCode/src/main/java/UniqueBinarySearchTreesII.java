import java.util.ArrayList;

/**
 * 思路: 根据左右子树构成二叉排序树
 */
public class UniqueBinarySearchTreesII {

    public ArrayList<TreeNode> generateTrees(int n) {
        return getnerateTrees(1, n);
    }

    /**
     * 获取所有二叉排序树
     * @param start
     * @param end
     * @return
     */
    public ArrayList<TreeNode> getnerateTrees(int start, int end) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();

        if (start > end) { //当start> end没有二叉排序树，所以添加空节点
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; ++i) {
            ArrayList<TreeNode> left = getnerateTrees(start, i-1);//左子树构成的所有二叉排序树
            ArrayList<TreeNode> right = getnerateTrees(i + 1, end);//右子树构成的所有二叉排序树

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    treeNodes.add(root);
                }
            }
        }
        return  treeNodes;
    }
}
