import org.junit.Test;

/**
 * 题目描述
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
 * 请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
 * 给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，
 * 否则则为障碍。另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，
 * 为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
 */
public class ComplexRobot {

    @Test
    public void test() {
        int[][] map = new int[][]
                {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}
                        , {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        countWays(map, 11, 4);
    }

    /**
     * 有障碍机器走格子，动态规划解决
     * @param map   格子
     * @param x 格子宽
     * @param y 格子长
     * @return 路径数
     */
    public int countWays(int[][] map, int x, int y) {
        int[][] dp = new int[x][y];//二维空间
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (map[i][j] == 0) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
                }
            }
        }
        return dp[x - 1][y - 1];
    }

    public int countWays_2(int[][] map, int x, int y) {
        // write code here
        int[] dp = new int[y];//一维空间实现
        dp[0] = 1;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(map[i][j] != 1)
                    dp[j] = 0;
                else if(j > 0)
                    dp[j] = (dp[j] + dp[j-1]) % 1000000007;
            }
        }

        return dp[y-1];
    }
}
