package grace.shuati;

/**
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (s.length() == 0) return true;
        if (s == null) return false;
        int start = 0, end = s.length() - 1;
        while (start < end) if (s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }
}
