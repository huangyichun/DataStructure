/**
 * 题目描述
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。
 * 请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 *
 * 思路: f(n) = f(n-1) + f(n-2) + f(n-3)
 * 取模运算有一个规则: (a+b)%c = ((a%c)+(b%c))%c
 */
public class GoUpstairs {
    public int countWays(int n) {
        if (n <= 0)
            return 0;
        // write code here
        int[] a = new int[4];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        if (n <= 3) {
            return a[n - 1];
        }

        for (int i = 4; i <= n; ++i) {
            a[3] = ((a[0] + a[1]) % 1000000007 + a[2]) % 1000000007;
            a[0] = a[1];
            a[1] = a[2];
            a[2] = a[3];
        }
        return a[3];
    }
}
