
/**
 * 红黑树
 */
public class RBTree<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;//根节点

    private class Node{
        Key key;    //键
        Value val;  //相关的值
        Node left ,right;   //左右子树
        int N;  //这棵子树的结点总数
        boolean color;  //由其父节点指向它的链接的颜色

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }


    }
    /**
     * 判断该节点是否是红色
     * @param x
     * @return
     */
    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }

    /**
     * 查找Key，找到则更新其值，否则新键一个节点
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    public void printfBST(){
        printfBST(root);
    }
    /**
     * 中序打印
     * @param node
     */
    private void printfBST(Node node){
        if(node == null)
            return;
        printfBST(node.left);
        System.out.print(node.key+" ");
        printfBST(node.right);
    }

    /**
     * 添加结点，如果存在修改，如果不存在创建新节点
     * @param h
     * @param key
     * @param val
     * @return
     */
    private Node put(Node h, Key key, Value val){
        if(h == null)//和父节点用红链接相连
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp >0) h.right = put(h.right, key, val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);//右节点为红色，左节点为黑色
        if(isRed(h.left) && isRed(h.left.left)) h= rotateRight(h);//左节点是红色，且它的左子节点也为红色
        if(isRed(h.left) && isRed(h.right)) flipColors(h);//左右子节点均为红色

        h.N = size(h.left) + size(h.right) + 1;//修改节点个数
        return h;
    }
    /**
     * 颜色转换
     * @param h
     */
    private void flipColors(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    /**
     * 右旋转
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    /**
     * 返回根节点这颗树的节点数
     * @return
     */
    public int size(){
        return size(root);
    }

    /**
     * 获取节点个数
     * @param node
     * @return
     */
    private int size(Node node){
        if(node == null)
            return 0;
        else
            return node.N;
    }
}
