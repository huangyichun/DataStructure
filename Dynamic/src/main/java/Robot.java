/**
 * 题目描述
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 *
 * 思路: f(x, y) = f(x-1, y) + f(x, y-1)
 */
public class Robot {
    public int countWays(int x, int y) {
        // write code here
        if(x == 1 || y == 1)
            return 1;
        return countWays(x-1, y) + countWays(x, y-1);
    }

    /**
     * 采用动态规划
     * @param x
     * @param y
     * @return
     */
    public int countWays_3(int x, int y){
        int[][] dp = new int[x][y];
        for(int i=1; i< x; ++i){
            dp[i][0] = 1;
        }
        for(int i=1; i <y; ++i){
            dp[0][i] = 1;
        }
        for(int i=1; i< x; ++i){
            for(int j=1; j<y; ++j){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[x-1][y-1];
    }

    /**
     * 使用数学计算法
     * @param x
     * @param y
     * @return
     */
    public int countWays_2(int x, int y){
        return fab(x + y) / (fab(x) * fab(y));
    }

    public int fab(int n){
        int sum = 1;
        for(int i=2; i<=n; ++i){
            sum *= i;
        }
        return sum;
    }
}
