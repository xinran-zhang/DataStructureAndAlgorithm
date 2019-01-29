package grace.shuati;


// minCut[i] 表示前i个字母，最少可以被分割为多少个回文串
// 最后return minCut[n] - 1
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] minCut = new int[s.length() + 1];
        minCut[0] = 0;

        for (int i = 1; i <= s.length(); i++) {
            minCut[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    minCut[i] = Math.min(minCut[i], minCut[j] + 1);
                }
            }
        }
        return minCut[s.length()] - 1;
    }

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
            }
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length] =
                        (isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length));
            }
        }
        return isPalindrome;
    }
}
