package grace.shuati;
import java.util.*;

public class StringPermutation {
    public boolean Permutation(String A, String B) {
        if (A.length() != B.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (map.containsKey(A.charAt(i))) {
                map.put(A.charAt(i), map.get(A.charAt(i)) + 1);
            } else {
                map.put(A.charAt(i), 1);
            }
        }

        for (int j = 0; j < B.length(); j++) {
            if (!map.containsKey(B.charAt(j))) {
                return false;
            }
            map.put(B.charAt(j), map.get(B.charAt(j)) - 1);
        }

        for (char c: map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
