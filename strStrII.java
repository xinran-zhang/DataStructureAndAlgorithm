package grace.shuati;

/**
 * Implement strStr function in O(n + m) time.
 * strStr return the first index of the target string in a source string.
 * The length of the target string is m and the length of the source string is n.
 * If target does not exist in source, just return -1.
 */

// Rabin Karp with time complexity of O(m+n) - m, n are the length of source and target
public class strStrII {
    public int strStr2(String source, String target) {
        if (source ==  null || target == null) return -1;

        // mod by base to ensure the hashcode doesn't go beyond the limit of integers
        int base = 1000000;
        int lenOfTarget = target.length();

        if (lenOfTarget == 0) return 0;

        // get 31^(lenOfTarget)
        int power = 1;
        for (int i = 0; i < lenOfTarget; i++) {
            power = (power * 31) % base;
        }

        // get the hashcode of the target string
        int hashCodeTarget = 0;
        for (int i = 0; i < target.length(); i++) {
            hashCodeTarget = (target.charAt(i) + hashCodeTarget * 31) % base;
        }

        int hashCodeSource = 0;
        for (int i = 0; i < source.length(); i++) {
            // abc + d
            hashCodeSource = (hashCodeSource * 31 + source.charAt(i)) % base;
            // this is to ensure to check the first lenOfTarget substring of source with target
            if (i < lenOfTarget - 1) continue;

            // abcd - a
            if (i >= lenOfTarget) {
                hashCodeSource = (hashCodeSource - source.charAt(i - lenOfTarget) * power) % base;
                if (hashCodeSource < 0) {
                    hashCodeSource = hashCodeSource + base;
                }
            }

            // double check if the substring of source and target are the same
            if (hashCodeSource == hashCodeTarget) {
                if (source.substring(i - lenOfTarget + 1, i + 1).equals(target)) {
                    return i - lenOfTarget + 1;
                }
            }
        }
        return -1;
    }
}
