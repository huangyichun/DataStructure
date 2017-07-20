/**
 * Created by huangyichun on 2017/7/7.
 */
public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree binarySearchTree = new ConvertSortedListToBinarySearchTree();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        TreeNode root = binarySearchTree.sortedListToBST(head);
        System.out.println();
    }


    private ListNode current = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        current = head;
        int size = 0;
        while(head != null) {
            ++size;
            head = head.next;
        }
        return buildBST(0, size-1);
    }

    private TreeNode buildBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2 ;
        TreeNode left = buildBST(start, mid - 1);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = buildBST(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
