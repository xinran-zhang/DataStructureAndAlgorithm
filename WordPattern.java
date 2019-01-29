package grace.shuati;
import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] s = str.split("\\s+");
        if (s.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!set.contains(s[i])) {
                    map.put(pattern.charAt(i), s[i]);
                    set.add(s[i]);
                } else {
                    return false;
                }
            } else {
                if (!map.get(pattern.charAt(i)).equals(s[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
