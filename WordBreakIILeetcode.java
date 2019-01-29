package grace.shuati;
import java.util.*;

public class WordBreakIILeetcode {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }

    private List<String> wordBreakHelper(String s, List<String> wordDict, Map<String, List> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }

        if (wordDict.contains(s)) {
            res.add(s);
        }

        for (int len = 1; len < s.length(); len++) {
            String prefix = s.substring(0, len);
            if (!wordDict.contains(prefix)) {
                continue;
            }
            String suffix = s.substring(len);
            List<String> segmentations = wordBreakHelper(suffix, wordDict, memo);
            for (String segmentation: segmentations) {
                res.add(prefix + " " + segmentation);
            }
        }
        memo.put(s, res);
        return res;
    }
}
