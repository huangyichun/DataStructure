/**
 * 题目描述
 * <p>
 * Given an array where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {


    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree binarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        int[] array = new int[] {1,2};
        TreeNode root = binarySearchTree.sortedArrayToBST(array);
        System.out.println();
    }
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(num[(end + start) / 2]);
        root.left = sortedArrayToBST(num, start, (end + start) / 2-1);
        root.right = sortedArrayToBST(num, (end + start) / 2 + 1, end);
        return root;
    }
}
