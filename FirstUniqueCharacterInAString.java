package grace.shuati;
import java.util.*;


/**
 * Find the first unique character in a given string.
 * You can assume that there is at least one unique character in the string.
 */

public class FirstUniqueCharacterInAString {
    public char firstUniqChar(String str) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.get(str.charAt(i)).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(str.charAt(i), list);
            }
        }

        Map<Character, Integer> unique = new HashMap<>();
        for (Character c: map.keySet()) {
            if (map.get(c).size() == 1) {
                unique.put(c, map.get(c).get(0));
            }
        }

        int smallestIndex = Integer.MAX_VALUE;
        for (Character c: unique.keySet()) {
            smallestIndex = Math.min(unique.get(c), smallestIndex);
        }

        return str.charAt(smallestIndex);
    }
}
