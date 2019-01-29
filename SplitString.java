package grace.shuati;
import java.util.*;

/**
 * Give a string, you can choose to split the string after one character
 * or two adjacent characters, and make the string to be composed of only one character or two characters.
 * Output all possible results.
 */

public class SplitString {
    public List<List<String>> splitString(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        if (s.length() == 0) {
            res.add(new ArrayList<String>());
            return res;
        }
        List<String> substring = new ArrayList<>();
        dfs(s, substring, res);
        return res;
    }

    private void dfs(String s, List<String> substrings, List<List<String>> res) {
        if (s.equals("")) {
            res.add(new ArrayList<>(substrings));
        }

        for (int i = 1; i <= 2; i++) {
            if (i <= s.length()) {
                substrings.add(s.substring(0, i));
                dfs(s.substring(i, s.length()), substrings, res);
                substrings.remove(substrings.size() - 1);
            }
        }
    }
}
