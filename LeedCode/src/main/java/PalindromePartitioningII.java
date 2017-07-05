/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s ="aab",
 * Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        for(int i = 0; i < dp.length-1; ++i) {
            dp[i+1] = i;
        }
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i; j < s.length(); ++j) {
                if(judgeIsPalindrome(s.substring(i, j + 1))){
                    dp[j + 1] = Math.min(dp[i] + 1, dp[j + 1]);
                }
            }
        }
        return dp[s.length()];
    }

    public boolean judgeIsPalindrome(String s){
        if (s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }
}
