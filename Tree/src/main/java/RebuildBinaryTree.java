import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * 思路:
 *      根据前序遍历将中序遍历分为左右子树，进行构造
 */
public class RebuildBinaryTree {


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        Map<Integer,Integer> map = new HashMap<>();
        //保存数字在中序中的位置
        for(int i=0; i<in.length; ++i){
            map.put(in[i], i);
        }
        return rebuildTree(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    public TreeNode rebuildTree(int[] pre, int pi, int pj, int[] in, int ni, int nj, Map<Integer,Integer> map){
        if(pi > pj || ni > nj)
            return null;
        TreeNode root = new TreeNode(pre[pi]);
        int index = map.get(pre[pi]);
        root.left = rebuildTree(pre, pi + 1, pi + index-ni, in, ni, index-1, map);
        root.right = rebuildTree(pre, pi + index-ni + 1, pj, in, index+1, nj, map);
        return root;
    }
}
