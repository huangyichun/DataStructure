/**
 * 取其中一个值为根节点，构成二叉排序树的个数为左右子树个数乘积
 * res[0] = 1 res[1] = 1
 * res[2] = res[0] * res[1] + res[1] * res[0] = 2
 * res[3] = res[0] * res[2] + res[1] * res[1] + res[2] * res[0] = 5
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i=2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                res[i] += res[j] * res[i -j -1];
            }
        }

        return res[n];
    }
}
