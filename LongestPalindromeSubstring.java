package grace.shuati;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0 || s == null) return "";
        String longest = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            if (helper(i, i , s).length() > longest.length()) {
                longest = helper(i, i, s);
            }
        }
        for (int i = 0; i < len - 1; i++) {
            if (helper(i, i + 1 , s).length() > longest.length()) {
                longest = helper(i, i + 1, s);
            }
        }
        return longest;
    }

    // helper method, which returns the longest palindrome string in string s
    public String helper(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                return s.substring(left + 1, right);
            }
        }
        return s.substring(left + 1, right);
    }


// initial thought: but this method could cause the time complexity to be O(n^3)
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len == 0 || s == null) return "";
//        String longest = s.substring(0, 1);
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j <= len; j++) {
//                if (isPalindrome(s.substring(i, j)) && s.substring(i, j).length() > longest.length()) {
//                    longest = s.substring(i, j);
//                }
//            }
//        }
//        return longest;
//    }
//
//    public boolean isPalindrome(String s) {
//        if (s.length() == 0 || s == null) return false;
//        int start = 0;
//        int end = s.length() - 1;
//        while (start <= end) {
//            if (s.charAt(start) == s.charAt(end)) {
//                start++;
//                end--;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}
