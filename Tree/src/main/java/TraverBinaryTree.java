import org.junit.Test;

import java.util.LinkedList;

/**
 * 前中后递归非递归遍历二叉树
 */
public class TraverBinaryTree {

    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        TreeNode node = new TreeNode(3);
        root.left = node;
        node = new TreeNode(6);
        root.right = node;
        node = new TreeNode(7);
        root.left.left = node;
        node = new TreeNode(8);
        root.left.right = node;
        node = new TreeNode(1);
        root.right.right = node;
        node = new TreeNode(2);
        root.right.right.left = node;
        node = new TreeNode(0);
        root.right.right.right = node;
        //------------------------------------
        System.out.print("递归先序遍历: ");
        preOrderRecur(root);

        System.out.println();
        System.out.printf("递归中序遍历: ");
        inOrderRecur(root);
        System.out.println();
        System.out.printf("递归后序遍历: ");
        postOrderRecur(root);
        //----------------------------------
        System.out.println();
        System.out.printf("非递归前序遍历:");;
        preOrderNoRecur(root);
        System.out.println();
        System.out.printf("非递归中序遍历:");;
        inOrderNoRecur(root);
        System.out.println();
        System.out.printf("非递归后序遍历:");;
        postOrderNoRecur(root);
    }

    /**
     * 递归前序遍历
     * @param root  根节点
     */
    public void preOrderRecur(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.val+" ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    /**
     * 非递归遍历前序
     * @param root  根节点
     */
    public void preOrderNoRecur(TreeNode root){
        if(root == null)
            return;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
            System.out.printf(node.val + " ");
        }
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void inOrderRecur(TreeNode root){
        if(root == null)
            return;
        inOrderRecur(root.left);
        System.out.print(root.val + " ");
        inOrderRecur(root.right);
    }

    /**
     * 非递归中序遍历
     * @param head
     */
    public void inOrderNoRecur(TreeNode head){
        if(head == null)
            return;
        TreeNode root = head;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || root != null){
            if(root !=  null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.printf(root.val + " ");
                root = root.right;
            }
        }
    }
    /**
     * 递归后序遍历
     * @param root
     */
    public void postOrderRecur(TreeNode root){
        if(root == null)
            return;
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.printf(root.val + " ");
    }

    /**
     * 非递归后序遍历
     * @param head
     */
    public void postOrderNoRecur(TreeNode head){
        if(head == null)
            return;
        TreeNode root = head;
        LinkedList<TreeNode> stack1 = new LinkedList<>();
        stack1.push(root);
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null)
                stack1.push(root.left);
            if(root.right != null)
                stack1.push(root.right);
        }
        while(!stack2.isEmpty()){
            System.out.printf(stack2.pop().val+ " ");
        }

    }
}
