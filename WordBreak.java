package grace.shuati;
import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        int maxLength = getMaxlength(dict);
        boolean[] canBreak = new boolean[n + 1];
        canBreak[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxLength && j <= i; j++) {
                String segmentation = s.substring(i - j, i);
                if (dict.contains(segmentation) && canBreak[i - j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }

        return canBreak[n];
    }

    private int getMaxlength(Set<String> dict) {
        int max = 0;
        for (String word: dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }

//    boolean canBreak = false;
//    public boolean wordBreak(String s, Set<String> dict) {
//        if (s.length() == 0) {
//            return true;
//        }
//        if (dict == null || dict.size() == 0) {
//            return false;
//        }
//
//        helper(s, dict, 0);
//        return canBreak;
//    }
//
//    private void helper(String s, Set<String> dict, int startIndex) {
//        if (startIndex == s.length()) {
//            canBreak = true;
//            return;
//        }
//
//        for (int i = startIndex; i < s.length(); i++) {
//            String word = s.substring(startIndex, i + 1);
//            if (dict.contains(word)) {
//                helper(s, dict, i + 1);
//            }
//        }
//    }
}
