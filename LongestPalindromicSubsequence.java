package grace.shuati;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 */

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int res = 0;
        int[][] memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            memo[i][i] = 1;
        }

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    memo[i][j] = 2 + memo[i + 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i][j - 1], memo[i + 1][j]);
                }
            }
        }

        return memo[0][s.length() - 1];
    }
}
