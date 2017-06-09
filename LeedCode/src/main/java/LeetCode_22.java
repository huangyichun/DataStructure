import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path1->2->3which represents the number123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *    1
 *  /  \
 * 2    3
 * <p>
 * The root-to-leaf path1->2represents the number12.
 * The root-to-leaf path1->3represents the number13.
 * Return the sum = 12 + 13 =25.
 */
public class LeetCode_22 {

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return sumNumbers(root, new ArrayList<>());
    }

    public int sumNumbers(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            int temp = 0;
            for(int i = 0; i < list.size(); ++i) {
                temp += list.get(i) * Math.pow(10, list.size() - i);
            }
            return temp + root.val;
        }
        list.add(root.val);
        int leftSum = 0, rightSum = 0;
        if (root.left != null){
            leftSum = sumNumbers(root.left, list);
        }
        if (root.right != null) {
            rightSum = sumNumbers(root.right, list);
        }
        list.remove(list.size()-1);
        return (leftSum + rightSum);
    }
}
