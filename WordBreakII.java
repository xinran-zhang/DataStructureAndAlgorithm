package grace.shuati;
import java.util.*;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence
 * where each word is a valid dictionary word.
 * Return all such possible sentences.
 */

public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // use a memo to store the relationship between a String s and its possible word break list of strings
        Map<String, ArrayList> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }

    private ArrayList<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, ArrayList> memo) {
        // if the String s's already in the map, return its corresponding arraylist
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        ArrayList<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }
        // edge case: no need to separate words by space
        if (wordDict.contains(s)) {
            res.add(s);
        }

        for (int len = 1; len < s.length(); len++) {
            String prefix = s.substring(0, len);
            if (!wordDict.contains(prefix)) {
                continue;
            }
            String suffix = s.substring(len);
            ArrayList<String> segmentations = wordBreakHelper(suffix, wordDict, memo);
            for (String segmentation: segmentations) {
                res.add(prefix + " " + segmentation);
            }
        }
        memo.put(s, res);
        return res;
    }

}
