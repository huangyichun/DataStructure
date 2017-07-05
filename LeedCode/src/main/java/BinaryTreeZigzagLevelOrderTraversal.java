import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 之字型打印二叉树
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return  result;
        }

        LinkedList<TreeNode> currentStack = new LinkedList<>();
        LinkedList<TreeNode> nextStack = new LinkedList<>();
        LinkedList<TreeNode> temp;
        currentStack.push(root);

        boolean normal = true;
        while(!currentStack.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while(!currentStack.isEmpty()) {
                TreeNode node = currentStack.pop();
                arrayList.add(node.val);

                if(normal) {
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                }else {
                    if (node.right != null) {
                        nextStack.push(node.right);
                    }
                    if (node.left != null) {
                        nextStack.push(node.left);
                    }
                }
            }
            result.add(arrayList);
            temp = currentStack;
            currentStack = nextStack;
            nextStack = temp;
            normal = !normal;
        }
        return result;
    }
}
