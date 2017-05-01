package bst;

/**
 * 二叉查找树实现
 */
public class BST <Key extends Comparable<Key>, Value> {

    private Node root; //根节点
    private class Node{
        private Key key;    //键
        private Value val;  //值
        private Node left, right; //左右子树的链接
        private int N;  //以该节点为根的子树中的节点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public void printfBST(){
        printfBST(root);
    }
    /**
     * 中序打印二叉查找树
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
     * 从根节点出发，查找树中排名为K的键，即正好有k个小于它的键
     * @param k
     * @return
     */
    public Key select(int k){
        return select(root, k).key;
    }

    /**
     * 删除最小键值的节点
     */
    public void deleteMin(){
        root = deleteMin(root);
    }

    /**
     * 删除键值为key的节点
     * @param key
     */
    public void delete(Key key){
        root = delete(root,key);
    }

    /**
     * 以Node为根节点删除某个键为key的节点
     * 1.首先找到值为Key的节点
     * 2.如果node没有右子树，返回node的左子树，
     * 如果node没有左子树，返回node的右子树
     * 3.如果node左右子树都存在，则在node的右子树中找到最小的一个
     * 节点，替代node
     * @param node
     * @param key
     * @return
     */
    private Node delete(Node node , Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = delete(node.left, key);
        else if(cmp > 0)
            node.right = delete(node.right, key);
        else {
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;

            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }
    /**
     * 以node为根节点删除最小的节点
     * @param node
     * @return
     */
    private Node deleteMin(Node node){
        if(node.left == null)
            return node.right;
        node.left = deleteMin(node.left);   //删除最小节点
        node.N = size(node.left) + size(node.right) + 1;//更新节点数
        return node;
    }
    /**
     * 从Node节点出发，查找树中排名为K的键，即正好有k个小于它的键
     * @param node
     * @param k
     * @return
     */
    private Node select(Node node, int k){
        if(node == null)
            return null;
        int t = size(node.left);//左子树个数
        if(t > k)       return select(node.left,k);
        else if(t < k)  return select(node.right, k-t-1);//右子树中查找
        else            return node;
    }

    /**
     * 从根节点开始查找Key
     * 如果存在返回，不存在找到第一个小于该key的键
     * @param key
     * @return
     */
    public Key floor(Key key){
        Node node = floor(root, key);
        if(node == null) return null;
        return node.key;
    }
    /**
     * 从node节点开始查找Key
     * 如果存在返回，不存在找到第一个小于该key的键
     * 即向下取整
     * @param node
     * @param key
     * @return
     */
    private Node floor(Node node, Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        else if(cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);//查找右子树中是否有小于Key的节点
        if(t != null) return t;
        else return node;
    }

    /**
     * 查找根节点最大的键
     * @return
     */
    public Key max(){
        return max(root).key;
    }
    /**
     *查找以node节点为根节点的最大键
     * 如果左子树为空，则当前节点为最大值
     * 否则最小值就是左子树的最大值
     * @param node
     * @return
     */
    private Node max(Node node){
        if(node.right == null)
            return node;
        return max(node.right);
    }

    /**
     * 查找根节点最小的键
     * @return
     */
    public Key min(){
        return min(root).key;
    }
    /**
     * 查找以node节点为根节点的最小键
     * 如果左子树为空，则当前节点为最小值
     * 否则最小值就是左子树的最小值
     * @param node
     * @return
     */
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }

    /**
     * 查找key存在则修改更新它的值，否则创建一个新的节点
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    /**
     * 如果Key存在于以node为根节点的子树中，则更新它的值
     * 否则将以key和Value为键值对的新节点插入到该子树中
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, Key key, Value value){
        if(node == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if(cmp < 0) node.left = put(node.left, key, value);
        else if(cmp > 0) node.right = put(node.right, key, value);
        else node.val = value;
        node.N = size(node.left) + size(node.right) + 1;//更新节点数
        return node;
    }

    /**
     * 获取Key对应的Value
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root, key);
    }

    /**
     * 在以node为根节点的子树中查找并返回Key所对应的值
     * @param node
     * @param key
     * @return
     */
    private Value get(Node node, Key key){
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp < 0) return get(node.left, key);
        else if(cmp > 0) return get(node.right, key);
        else return node.val;
    }
    /**
     * 获取二叉查找树节点个数
     * 满足 size(x) = size(x.left) + size(x.right) + 1；
     * 对于空链接size(x)返回0
     * @return  返回节点个数
     */
    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node == null)
            return 0;
        else
            return node.N;
    }
}
