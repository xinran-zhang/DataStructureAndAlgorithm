package grace.shuati;

/**
 * Given a non-empty string s, you may delete at most one character.
 * Judge whether you can make it a palindrome.
 */


// when first encounter s[left] != s[right], remove either s[left] or s[right] to see if the rest is Palindrome
// need to know how to proof that
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }

        if (left >= right) {
            return true;
        }

        return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);

    }

    public boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
