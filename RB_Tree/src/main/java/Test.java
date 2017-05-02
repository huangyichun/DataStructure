/**
 * Created by huangyichun on 2017/5/2.
 */
public class Test {
    public static void main(String[] args) {
        RBTree<Integer,Character> rbTree = new RBTree();
        rbTree.put(18,'A');
        rbTree.put(14, 'B');
        rbTree.put(22, 'C');
        rbTree.put(10, 'D');
        rbTree.put(15, 'E');
        rbTree.put(19, 'F');
        rbTree.put(25, 'G');
        rbTree.put(8, 'H');
        rbTree.put(11, 'I');
        rbTree.put(23, 'J');
        rbTree.put(7, 'K');
       rbTree.printfBST();
    }
}
