package bst;

/**
 * 二叉排序树测试
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer,Character> bst = new BST<Integer, Character>();
        bst.put(15,'A');
        bst.put(13,'B');
        bst.put(11,'D');
        bst.put(8,'H');
        bst.put(14,'E');
        bst.put(20,'C');
        bst.put(17,'F');
        bst.put(11,'G');

        bst.printfBST();
        System.out.println();
        System.out.println("最大键:" + bst.max());//打印最大键
        System.out.println("最小键:" + bst.min());//打印最小键
        System.out.println("Key= 15, value=" + bst.get(15));
        System.out.println("节点个数为:" + bst.size());

        bst.delete(13);//删除13这个节点
        bst.printfBST();
//        bst.deleteMin();
//        bst.printfBST();
    }
}
