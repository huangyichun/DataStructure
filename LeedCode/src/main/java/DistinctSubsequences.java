/**
 * 题目描述
 * <p>
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).
 * <p>
 * Here is an example:
 * S ="rabbbit", T ="rabbit"
 * Return3.
 * <p>
 * 给定两个字符串S和T，求S有多少个不同的子串与T相同。S的子串定义为在S中任意去掉0个或者多个字符形成的串。
 * <p>
 * 思路：dp题。
 * 状态定义：dp[i][j]代表s[0~i-1]中T[0~j-1]不同子串的个数。
 * 递推关系式：S[i-1]!= T[j-1]：  DP[i][j] = DP[i][j-1] （不选择S中的s[i-1]字符）
 * S[i-1]==T[j-1]： DP[i][j] = DP[i-1][j-1]（选择S中的s[i-1]字符） + DP[i][j-1]
 * 初始状态：第0列：DP[i][0] = 0，第0行：DP[0][j] = 1
 *  
 */


public class DistinctSubsequences {

    public int numDistinct(String S, String T) {

        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i <= S.length(); ++i) {
            dp[0][i] = 1;
        }


        for (int i = 1; i <= T.length(); ++i) {
            for (int j = 1; j <= S.length(); ++j) {
                dp[i][j] = dp[i][j-1];
                if (S.charAt(j - 1) == T.charAt(i - 1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }
}
