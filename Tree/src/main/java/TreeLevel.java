import java.util.LinkedList;

/**
 * 题目描述
 * 对于一棵二叉树，请设计一个算法，创建含有某一深度上所有结点的链表。
 * 给定二叉树的根结点指针TreeNode* root，以及链表上结点的深度，请返回
 * 一个链表ListNode，代表该深度上所有结点的值，请按树上从左往右的顺序链接
 * ，保证深度不超过树的高度，树上结点的值为非负整数且不超过100000。
 */
public class TreeLevel {

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        if (root == null || dep == 0)
            return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (dep > 1) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null) {
                    queue.offer(node.right);
                }
                --count;
            }
            --dep;
        }
        ListNode head = new ListNode(-1);
        ListNode list = head;
        while (!queue.isEmpty()) {
            ListNode node = new ListNode(queue.poll().val);
            list.next = node;
            list = node;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}