package grace.shuati;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) return -1;
        if (needle.length() == 0 || haystack.equals(needle)) return 0;
        int lenofneedle = needle.length();
        for (int i = 0; i <= haystack.length() - lenofneedle; i++) {
            if (haystack.substring(i, i + lenofneedle).equals(needle)) return i;
        }
        return -1;
    }
}
