package grace.shuati;
import java.util.*;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        // map is used to record the match between pattern and str
        // set is to ensure elements in pattern doesn't correspond to the same string
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return dfs(pattern, str, map, set);
    }

    private boolean dfs(String pattern, String str, Map<Character, String> map, Set<String> set) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char c = pattern.charAt(0);
        if (map.containsKey(c)) {
            if (!str.startsWith(map.get(c))) {
                return false;
            }
            return dfs(pattern.substring(1), str.substring(map.get(c).length()), map, set);
        }

        for (int i = 0; i < str.length(); i++) {
            String word = str.substring(0, i + 1);
            if (set.contains(word)) {
                continue;
            }
            map.put(c, word);
            set.add(word);
            // if rest of the string matches the pattern, then it matches
            if (dfs(pattern.substring(1), str.substring(i + 1), map, set)) {
                return true;
            }
            map.remove(c, word);
            set.remove(word);
        }
        return false;
    }
}