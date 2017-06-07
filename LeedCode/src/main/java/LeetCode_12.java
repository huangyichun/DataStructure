import java.util.Set;

/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s ="leetcode",
 * dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code".
 */
public class LeetCode_12 {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i=0; i< s.length(); ++i) {
            for (int j=i; dp[i] && j < s.length(); ++j) {
                if(dict.contains(s.substring(i, j+1))) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
